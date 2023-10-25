const { MessageInteraction } = require('discord.js');


function checkIfInteractionIsCommand(interaction) {

    if(!interaction.isCommand()) {
        // this is not a command so function should break
        return false;
    } else {
        return true;
    }

}

module.exports = { checkIfInteractionIsCommand }