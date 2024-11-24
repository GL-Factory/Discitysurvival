package com.citysurvival.enums;

import lombok.Getter;

@Getter
public enum ExplorationEnum {
    EVENT_NOTHING_FOUND(10, "You find nothing."),
    EVENT_RESOURCES_FOUND(20, "You found some resources."),
    EVENT_RATION_FOUND(20, "You found some rations."),
    EVENT_MONSTER_ATTACK(25, "A monster is attacking you."),
    EVENT_TRAP(25, "You fell in a trap.");

    private final int probability;
    private final String message;

    // Constructor to set the probability and the message
    ExplorationEnum(int probability, String message) {
        this.probability = probability;
        this.message = message;
    }
}
