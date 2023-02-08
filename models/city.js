let state = {
    "player_list" : {},
    "inventory": {
        "water" : 0,
        "food" : 0,
        "kit" : 0,
        "wood" : 0
    },
    "doorOpen": false
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
    } ;
}
function isEnrolled(username){
    return Object.keys(global_storage['player_list']).includes(username) ;
}

function isDoorOpen()   { return state.doorOpen ; }
function doorClose()    { state.doorOpen = false ; }
function doorOpen()     { state.doorOpen = true ; }

let door = {
    "isOpen"    : isDoorOpen,
    "open"      : doorClose,
    "close"     : doorOpen
}

module.exports = { state, enrollNewPlayer, isEnrolled, door }

