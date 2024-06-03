package com.citysurvival.exception;

public class PlayerAlreadyAtLocationException extends RuntimeException{

    public PlayerAlreadyAtLocationException(String playerDiscordName, String playerLocation) {
        super(String.format("The player %s is already at the location %s", playerDiscordName, playerLocation));
    }
}
