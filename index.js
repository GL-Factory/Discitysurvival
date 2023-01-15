const fs = require('node:fs');
const path = require('node:path');
const { Client, Collection, Events, GatewayIntentBits } = require('discord.js');
const { token } = require('./config.json');

const client = new Client({
    intents: [
        GatewayIntentBits.Guilds,
        GatewayIntentBits.GuildMessages,
        GatewayIntentBits.MessageContent
    ]
});


client.login(token)

client.commands = new Collection();

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

//démarrage du bot
/*
Point sur les commandes au lancement du bot :
   //client.guilds.cache.get("idserver").commands.create(data); //via l'id du serveur ça peut prendre moinds de temps

    //lient.guilds.cache.get("idserver").commands.fetch(); // recharger les commandes dans le cache

    //client.guilds.cache.get("idserver").commands.cache; // pour obtenir le cache
    
    //client.guilds.cache.get("idserver").commands.cache.map(command => { command.delete();}) //supprimer les commandes dans le cache 
*/
client.once(Events.ClientReady, c => {

	console.log('Ready! Logged in as ${c.user.tag}');
});

client.on(Events.InteractionCreate, async interaction => {
	if (!interaction.isChatInputCommand()) return;

	const command = interaction.client.commands.get(interaction.commandName);

	if (!command) {
		console.error(`No command matching ${interaction.commandName} was found.`);
		return;
	}

	try {
		await command.execute(interaction);
	} catch (error) {
		console.error(error);
		await interaction.reply({ content: 'There was an error while executing this command!', ephemeral: true });
	}
})
//


//simples intércations avec la lecture d'un message
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
