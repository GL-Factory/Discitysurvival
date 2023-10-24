const { SlashCommandBuilder } = require('discord.js');

const wait = require('node:timers/promises').setTimeout;
let city = require('../models/city.js');

module.exports = {
	data: new SlashCommandBuilder()
    .setName("getout")
    .setDescription("Permet à l'utilisateur de sortir de la ville"),
	async execute(interaction) {
        try {
            if(interaction.isCommand()){
                if(interaction.commandName === "getout"){ 
                    let user = interaction.user;
                    if(city.isEnrolled(user.username)) {
                        let gameUser = city.state.player_list[user.username];
                        if(gameUser.localisation != "in") {
                            await interaction.reply(`Impossible de sortir, ${user}, vous avez êtes déjà dehors`);
                        } else {
                            city.goOut(user.username);
                            await interaction.reply(`${user}, vous êtes sortis de votre magnifique ville, attention à vous`);
                        }
                    } else {
                        await interaction.reply(`${user}, vous ne faites pas partie de la ville impossible de sortir lorsque l'on existe pas pensez à /join`);
                    }
                    
                } else {
                    interaction.reply({ content: 'Une erreur etrange de commande est apparue', ephemeral: true});
                }
            } 
        } catch(error){
            console.error(error); //TODO voir pour le logging plus efficace
            await interaction.reply({ content: 'Une erreur est survenue', ephemeral: true }); //
        }
 
    }
};