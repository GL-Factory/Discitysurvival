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
                    if(not(city.isEnrolled(user))){
                        city.enrollNewPlayer(user)
                    
                        //message à afficher au joueur si tout se passe bien
                        await interaction.reply(`Bienvenue ${user}, vous avez rejoint la magnifique ville de ${nameCity}`);
                    }else {
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
        
