package com.citysurvival.services;

public enum Locations {
    IN_TOWN("In Town"),
    OUT_OF_TOWN("Out of Town");

    private String name;

    Locations(String location) {
        this.name = location;
    }

    public String getName() {
        return name;
    }
}
