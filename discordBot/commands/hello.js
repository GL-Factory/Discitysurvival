const { SlashCommandBuilder } = require('discord.js');

module.exports = {
	data: new SlashCommandBuilder()
    .setName("hello")
    .setDescription("Its me"),
	async execute(interaction) {
        if(interaction.isCommand()){
            if(interaction.commandName === "hello"){
                
                await interaction.reply("Welcome to the other siiiiiiiide");
                
            }
        }  
    }
};
        