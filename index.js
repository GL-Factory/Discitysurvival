const { Client, GatewayIntentBits } = require("discord.js");
const { TOKEN_LOGIN } = require("./apikey.js");

const client = new Client({
    intents: [
        GatewayIntentBits.Guilds,
        GatewayIntentBits.GuildMessages,
        GatewayIntentBits.MessageContent
    ]
});

client.on("ready", () => {
    console.log("bot opérationnel");
})

client.on("messageCreate", message => {
    if(message.author.bot) return;
    console.log(message);
    if(message.content==="Marco"){
        message.reply("Polo");
        message.channel.send("Polo");
        console.log("Polo");
    }
    if(message.content==="ping"){
        
        message.reply("pong");
        console.log("pong");
        message.channel.send("pong");
    }


    if(message.content === "help"){
        message.reply("Liste des commandes bots : \n");
        //TODO boucle sur les différentes commandes, à orga quelque part pour que ça soit pas à la main, tableau de correspondance des commandes à une fonction ? 
    }

    if( message.content === "mention"){
        message.reply("Mention du user : <@"+message.author.id + "> \n Mention d'un salon : <#" + message.channel.id + ">" );
    }
})

client.login(TOKEN_LOGIN) 