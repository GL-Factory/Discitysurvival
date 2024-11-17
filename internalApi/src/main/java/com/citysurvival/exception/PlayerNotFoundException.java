package com.citysurvival.exception;

public class PlayerNotFoundException extends RuntimeException{

    public PlayerNotFoundException(String playerDiscordName) {
        super(String.format("A player with the following discord name : %s already exist", playerDiscordName));
    }
}
