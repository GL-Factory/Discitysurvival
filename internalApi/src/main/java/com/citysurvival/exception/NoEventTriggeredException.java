package com.citysurvival.exception;

public class NoEventTriggeredException extends RuntimeException{

    public NoEventTriggeredException(){
        super("No event happened");
    }

}
