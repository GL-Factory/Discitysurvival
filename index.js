const fs = require('node:fs');
const path = require('node:path');

const { Client, Collection, GatewayIntentBits } = require('discord.js');
const { token } = require('./config.json');

const client = new Client({
    intents: [
        GatewayIntentBits.Guilds,
        GatewayIntentBits.GuildMessages,
        GatewayIntentBits.MessageContent
    ]
});

client.commands = new Collection(); //pour accès dans un autre fichier si besoin

const commandsPath = path.join(__dirname, 'commands');
const commandFiles = fs.readdirSync(commandsPath).filter(file => file.endsWith('.js'));

for (const file of commandFiles) {
	const filePath = path.join(commandsPath, file);
	const command = require(filePath);
	// Set a new item in the Collection with the key as the command name and the value as the exported module
	if ('data' in command && 'execute' in command) {
		client.commands.set(command.data.name, command);
	} else {
		console.log(`[WARNING] The command at ${filePath} is missing a required "data" or "execute" property.`);
	}
}

// similaiore aux commands pour  gérer les events : 
const eventsPath = path.join(__dirname, 'events');
const eventFiles = fs.readdirSync(eventsPath).filter(file => file.endsWith('.js'));

for (const file of eventFiles) {
	const filePath = path.join(eventsPath, file);
	const event = require(filePath);
	if (event.once) {
		client.once(event.name, (...args) => event.execute(...args));
	} else {
		client.on(event.name, (...args) => event.execute(...args));
	}
}

//simples intércations avec la lecture d'un message, mais préférer les commandes si envie de créer une action spécifique on demands
client.on("messageCreate", message => {

    if(message.author.bot) 
        return;

    if(message.content==="Marco"){

        message.reply("Polo"); //methode 1
    }
    if(message.content==="ping"){
        
        message.channel.send("pong"); //methode 2
    }

    if(message.content === "help"){
        message.reply("Liste des commandes bots : \n");
        //TODO boucle sur les différentes commandes, à orga quelque part pour que ça soit pas à la main, tableau de correspondance des commandes à une fonction ? 
    }

    if( message.content === "mention"){
        message.reply("Mention du user : <@"+message.author.id + "> \n Mention d'un salon : <#" + message.channel.id + ">" );
    }

    if(message.content === "pan"){
      message.reply("ET PAN UNE CLAQUETTE DANS LA TÊTE DE <@147059697776590848>"); //pauvre Draeky
    }
})



client.login(token)
