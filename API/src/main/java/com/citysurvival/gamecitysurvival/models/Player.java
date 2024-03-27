package com.citysurvival.gamecitysurvival.models;

import com.citysurvival.gamecitysurvival.enums.Locations;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    private Inventory playerInventory;
    private Locations location;

    public Player(String name) {
        this.name = name;
        this.playerInventory = new Inventory(0, 0, 0, 0, 0);
        this.location = Locations.IN;
    }

    public void getOut() {
        if (this.location != Locations.OUT) {
            this.location = Locations.OUT;
        }
    }


}
