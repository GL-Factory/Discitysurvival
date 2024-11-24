package com.citysurvival.exception;

public class PlayerHasNotEnoughEnergyException extends RuntimeException{

    public PlayerHasNotEnoughEnergyException(String playerDiscordName) {
        super(String.format("The player : %s do not have enough energy to perform the action", playerDiscordName));
    }
}
