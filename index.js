const { Client, GatewayIntentBits } = require("discord.js");
const client = new Client({
    intents: [
        GatewayIntentBits.Guilds
    ]
});

client.on("ready", () => {
    console.log("bot opérationnel");
})

client.login("") //mettre la clé du discord en secret