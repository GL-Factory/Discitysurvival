package com.citysurvival.exception;

public class PlayerHasNoWaterException extends RuntimeException {

    public PlayerHasNoWaterException(String playerDiscordName) {
        super(String.format("The player : %s do not have enough water to perform the action", playerDiscordName));
    }

}