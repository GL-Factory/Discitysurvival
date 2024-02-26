package com.citysurvival.gamecitysurvival.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Inventory {

    private int water;
    private int food;
    private int medKit;
    private int wood;
    private int rock;


    public void addWater(int numberToAdd) {
        this.water += numberToAdd;
    }

    public void removeWater(int numberToRemove) {
        this.water -= numberToRemove;
    }

    public void addFood(int numberToAdd) {
        this.food += numberToAdd;
    }

    public void removeFood(int numberToRemove) {
        this.food -= numberToRemove;
    }

    public void addMedKit(int numberToAdd) {
        this.medKit += numberToAdd;
    }

    public void removeMedKit(int numberToRemove) {
        this.medKit -= numberToRemove;
    }

    public void addWood(int numberToAdd) {
        this.wood += numberToAdd;
    }

    public void removeWood(int numberToRemove) {
        this.wood -= numberToRemove;
    }

    public void addRock(int numberToAdd) {
        this.rock += numberToAdd;
    }

    public void removeRock(int numberToRemove) {
        this.rock -= numberToRemove;
    }


}
