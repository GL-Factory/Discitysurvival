const { SlashCommandBuilder } = require('discord.js');

const axios = require('axios');

module.exports = {
    data: new SlashCommandBuilder()
        .setName("list_city")
        .setDescription("List available cities"),
    async execute(interaction) {
        if(interaction.isCommand()){
            if(interaction.commandName === "list_city"){
                let user = interaction.user ;
                try{
                    const url = process.env.API_BASE_URL + '/world/city/list'
                    const worldName = process.env.WORLD_NAME

                    const response = await axios.post(
                        url,
                        worldName,
                        {
                            headers: {
                                'Content-Type': 'text/plain'
                            }
                        }
                    );

                    await interaction.reply('Voici la liste des cités : '  + response.data);
                }catch(error){
                    console.error(error); //TODO voir pour le logging plus efficace
                    await interaction.reply({ content: 'Une erreur est survenue', ephemeral: true }); //

                }
            }
        }
    }
};

