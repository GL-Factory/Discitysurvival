package com.citysurvival.services;

import com.citysurvival.models.Inventory;

public class InventoryService {

    public void findRation(Inventory inventory) {
        inventory.setFood(inventory.getFood() +1);
        inventory.setWater(inventory.getWater() +1);
        double random = Math.random();
        if(random > 0.9) {
            inventory.setKit(inventory.getKit() + 1);
        }
    }

    public void findResources(Inventory inventory) {
        inventory.setWood(inventory.getWood() +1);
        inventory.setRock(inventory.getRock() + 1);
    }

    public void fallIntoTrap(Inventory inventory) {
        double random = Math.random();
        if(random > 0.5) {
            inventory.setFood(inventory.getFood() - 1);
            inventory.setWater(inventory.getWater() - 1);
            double random2 = Math.random();
            if(random2 > 0.9) {
                inventory.setKit(inventory.getKit() - 1);
            }
        } else {
            inventory.setWood(inventory.getWood() - 1);
            inventory.setRock(inventory.getRock() - 1);
        }
    }
}
