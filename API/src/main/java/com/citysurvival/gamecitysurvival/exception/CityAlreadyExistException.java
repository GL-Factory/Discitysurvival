package com.citysurvival.gamecitysurvival.exception;

public class CityAlreadyExistException extends RuntimeException {

    public CityAlreadyExistException() {
        super("This city already exist");
    }
}
