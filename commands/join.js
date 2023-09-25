const { SlashCommandBuilder } = require('discord.js');
let city = require('../models/city.js');

module.exports = {
	data: new SlashCommandBuilder()
    .setName("join")
    .setDescription("Join a city"),
	async execute(interaction) {
        if(interaction.isCommand()){
            if(interaction.commandName === "join"){
                let user = interaction.user ;
                let nameCity = "POUETLAND";
                try{
                    let userName = user.username;
                    if(!(city.isEnrolled(userName))){
                        city.enrollNewPlayer(userName)
                        //message à afficher au joueur si tout se passe bien
                        await interaction.reply(`Bienvenue ${user}, vous avez rejoint la magnifique ville de ${nameCity}`);
                    }else {
                        console.log("else join");
                        await interaction.reply(`Rebonjour ${user}. Vous avez déjà rejoint la magnifique ville de ${nameCity}`); 
                    }
                }catch(error){
                    console.error(error); //TODO voir pour le logging plus efficace
                    await interaction.reply({ content: 'Une erreur est survenue', ephemeral: true }); //
                }
            }
        }  
    }
};
        
