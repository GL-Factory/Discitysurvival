const { SlashCommandBuilder } = require('discord.js');

module.exports = {
	data: new SlashCommandBuilder()
    .setName("hello")
    .setDescription("Its me")
    .addUserOption(option => option
        .setName("utilisateur")
        .setRequired(false)),

	async execute(interaction) {
        if(interaction.isCommand()){
            if(interaction.commandName === "hello"){
                let paramUser = interaction.options.getUser("utilisateur");
                if( paramUser != undefined){
                 
                    await interaction.reply("<@"+ paramUser.id +"> Welcome to the other siiiiiiiiiiide");
 
                }else{
 
                    await interaction.reply("Welcome to the other siiiiiiiide");
                }
 
            }
        }  
    }
};
        