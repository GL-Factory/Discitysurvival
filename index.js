const { Client, GatewayIntentBits } = require("discord.js");
const { TOKEN_LOGIN } = require("./apikey.js");
const {SlashCommandBuilder } = require("@discordjs/builders");

const client = new Client({
    intents: [
        GatewayIntentBits.Guilds,
        GatewayIntentBits.GuildMessages,
        GatewayIntentBits.MessageContent
    ]
});

//démarrage du bot
/*
Point sur les commandes au lancement du bot :
   //client.guilds.cache.get("idserver").commands.create(data); //via l'id du serveur ça peut prendre moinds de temps

    //lient.guilds.cache.get("idserver").commands.fetch(); // recharger les commandes dans le cache

    //client.guilds.cache.get("idserver").commands.cache; // pour obtenir le cache
    
    //client.guilds.cache.get("idserver").commands.cache.map(command => { command.delete();}) //supprimer les commandes dans le cache 
*/
client.on("ready", () => {

    client.application.commands.create(data); 

 
    console.log("bot opérationnel");
})
//

//Commande
const data = new SlashCommandBuilder()
    .setName("camion")
    .setDescription("blague très mature")
    .addUserOption(option => option
        .setName("utilisateur")
        .setDescription("utilisateur à pouet pouet")
        .setRequired(false))
        ;


client.on("interactionCreate", interaction => {
    if(interaction.isCommand()){
       if(interaction.commandName === "camion"){
            let paramUser = interaction.options.getUser("utilisateur");
            if( paramUser != undefined){
                
               interaction.reply("<@"+ paramUser.id +"> pouet pouet");

            }else{

                interaction.reply("pouet pouet");
            }

         }
    }
});

//    

//simples intércations avec la lecture d'un message
client.on("messageCreate", message => {

    if(message.author.bot) return;

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

client.login(TOKEN_LOGIN) //connexion du bot à l'api discord