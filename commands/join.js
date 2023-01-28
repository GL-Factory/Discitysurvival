const { SlashCommandBuilder } = require('discord.js');
let global_storage = require('../models/varGlobales.js');

module.exports = {
	data: new SlashCommandBuilder()
    .setName("join")
    .setDescription("Join a city"),
	async execute(interaction) {
        if(interaction.isCommand()){
            if(interaction.commandName === "join"){
                let user = interaction.targetUser ;
                let nameCity = "POUETLAND";

                console.log(global_storage);
                console.log(global_storage['player_list']);
                try{
                    if(Object.keys(global_storage['player_list']).includes(user)){
                        await interaction.reply("Vous avez déjà rejoint la magnifique ville de `{nameCity}`"); 
                    }

                    else {
                        //TODO bloc logique pour la création de ville et d'ajout du joueur dans la ville #version1
                        global_storage['player_list'][user] =  {
                            "localisation" : "in",
                            "inventory": {
                                "water" : 0,
                                "food" : 0,
                                "kit" : 0,
                                "wood" : 0,
                                "rock" : 0
                            },
                            "state": {
                                "hunger": 0, // 0 Sustenté / 1 Acceptable / 2 Affamé / 3 Mort
                                "thirst": 0 // 0 Hydraté / 1 Acceptable / 2 Déshydraté / 3 Mort
                            }
                        }
                    
                        //message à afficher au joueur si tout se passe bien
                        await interaction.reply("Vous avez rejoint la magnifique ville de `{nameCity}");
                    }
                
                
                }catch(error){
                    console.error(error); //TODO voir pour le logging plus efficace
                    await interaction.reply({ content: 'Une erreur est survenue', ephemeral: true }); //
                
                }
            }
        }  
    }
};
        