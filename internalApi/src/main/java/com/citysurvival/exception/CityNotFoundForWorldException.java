package com.citysurvival.exception;

public class CityNotFoundForWorldException extends RuntimeException{

    public CityNotFoundForWorldException(String cityName, String worldName){
        super(String.format("The city : %s was not found for World %s", cityName, worldName));
    }
}
