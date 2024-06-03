package com.citysurvival.exception;

public class WorldNotFoundException extends RuntimeException{

    public WorldNotFoundException(String worldSearched){
        super(String.format("This world : %s was not found", worldSearched));
    }

}
