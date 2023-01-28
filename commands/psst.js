const { SlashCommandBuilder } = require('discord.js');

const wait = require('node:timers/promises').setTimeout;

module.exports = {
	data: new SlashCommandBuilder()
    .setName("psst")
    .setDescription(":3"),
	async execute(interaction) {
        if(interaction.isCommand()){
            if(interaction.commandName === "psst"){
                
                //await interaction.reply("è.é"); //peut pas être utilisé en plus 
                await interaction.reply({ content: 'I\'m not your cat !', ephemeral: true });
                await wait(2000);
                await interaction.editReply('I\'m Watching you');	
                await wait(2000);
                await interaction.followUp({ content: 'WATCH OUT!', ephemeral: true });

            }
        }  
    }
};