const { SlashCommandBuilder } = require('discord.js');

const wait = require('node:timers/promises').setTimeout;
let city = require('../models/city.js');

module.exports = {
	data: new SlashCommandBuilder()
    .setName("explore")
    .setDescription("Permet à l'utilisateur d'explorer le monde"),
	async execute(interaction) {
        console.log(city);
        if(interaction.isCommand()){
            if(interaction.commandName === "explore"){ 
                let user = interaction.user;
                let gameUser = city.state.player_list[user];
                console.log(gameUser);
                console.log("Utilisateur : " + user.username + " pars en exploration");
                let random = Math.floor(Math.random() * 101);
                console.log("Nombre aléatoire généré pour l'utilisateur " + user.username + " est :" + random);
                if (random <= 10) {
                    await interaction.reply({ content: 'Vous ne trouvez rien', ephemeral: true });
                } else if (random > 10 && random <= 30) {
                    await interaction.reply({ content: 'Vous trouvez des ressources', ephemeral: true });
                } else if (random > 30 && random <= 50) {
                    console.log(city.state.inventory);
                    await interaction.reply({ content: 'Vous trouvez des rations', ephemeral: true });
                } else if (random > 50 && random <=75) {
                    await interaction.reply({ content: 'Un monstre vous attaque', ephemeral: true });
                } else if (random > 75 && random <=100) {
                    await interaction.reply({ content: 'Vous êtes tombé dans un piège', ephemeral: true });
                }
            } else {
                interaction.reply({ content: 'Une erreur etrange c\'est glissée ici', ephemeral: true});
            }
        }  
    }
};