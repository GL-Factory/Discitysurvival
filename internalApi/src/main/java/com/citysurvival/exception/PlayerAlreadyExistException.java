package com.citysurvival.exception;

public class PlayerAlreadyExistException extends RuntimeException {

    public PlayerAlreadyExistException(String playerDiscordName) {
        super(String.format("A player with the following discord name : %s already exist", playerDiscordName));
    }
}
