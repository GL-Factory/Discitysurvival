let state = {
    "player_list" : {},
    "inventory": {
        "water" : 0,
        "food" : 0,
        "kit" : 0,
        "wood" : 0
    }
}
function enrollNewPlayer(username){
    if(isEnrolled(username)) {
        // Kaboom
        return
    }
    state.player_list[username] = {
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
        }, 
        "location": "city" // city / wild for now
    }
    console.log(state);
}
function isEnrolled(username){
    return Object.keys(state['player_list']).includes(username)
}

module.exports = { state, enrollNewPlayer, isEnrolled }

