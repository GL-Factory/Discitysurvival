const { SlashCommandBuilder } = require('discord.js');

module.exports = {
	data: new SlashCommandBuilder()
    .setName("camion")
    .setDescription("blague très mature")
    .addUserOption(option => option
        .setName("utilisateur")
        .setDescription("utilisateur à pouet pouet")
        .setRequired(false)),

	async execute(interaction) {
        if(interaction.isCommand()){
            if(interaction.commandName === "camion"){
                let paramUser = interaction.options.getUser("utilisateur");
                if( paramUser != undefined){
                 
                    await interaction.reply("<@"+ paramUser.id +"> pouet pouet");
 
                }else{
 
                    await interaction.reply("pouet pouet");
                }
 
            }
        }  
    }
};
        