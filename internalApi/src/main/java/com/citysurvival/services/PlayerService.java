package com.citysurvival.services;

import com.citysurvival.daos.PlayerRepository;
import com.citysurvival.enums.ExplorationEnum;
import com.citysurvival.exception.NoEventTriggeredException;
import com.citysurvival.exception.PlayerAlreadyAtLocationException;
import com.citysurvival.exception.PlayerNotFoundException;
import com.citysurvival.models.Inventory;
import com.citysurvival.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    InventoryService inventoryService;

    private static final Random random = new Random();
    private static final ExplorationEnum[] events = ExplorationEnum.values();

    public Player makePlayerLeaveCity(String discordName) {
        return switchLocation(discordName, Locations.OUT_OF_TOWN);
    }

    public Player makePlayerGoBackToCity(String discordName) {
        return switchLocation(discordName, Locations.IN_TOWN);
    }

    private Player switchLocation(String discordName, Locations desiredLocation) {
        Player foundPlayer = playerRepository.findByDiscordName(discordName);
        if (foundPlayer != null) {
            if (Objects.equals(foundPlayer.getLocation(), desiredLocation.getName())) {
                Locations otherLocation = Arrays.stream(Locations.values())
                        .filter(d -> d != desiredLocation)
                        .findFirst().get();
                foundPlayer.setLocation(otherLocation.getName());
                playerRepository.save(foundPlayer);
                return foundPlayer;
            } else {
                throw new PlayerAlreadyAtLocationException(discordName, desiredLocation.getName());
            }
        } else {
            throw new PlayerNotFoundException(discordName);
        }
    }


    private ExplorationEnum explore(String discordName) {
        Player foundPlayer = playerRepository.findByDiscordName(discordName);
        if (foundPlayer != null) {
            Inventory foundPlayerInventory = foundPlayer.getInventory();
            int randomValue = random.nextInt(100) + 1;
            int cumulativeProbability = 0;
            int[] eventProbabilities = getEventProbabilitiesFromExploreEvent();  // Assuming this method exists

            // Iterate over the events and check which range the random value falls into
            for (int i = 0; i < events.length; i++) {
                cumulativeProbability += eventProbabilities[i];

                if (randomValue <= cumulativeProbability) {
                    ExplorationEnum eventTriggered = events[i];

                    // Handle the event with a switch statement to minimize repetition
                    switch (eventTriggered) {
                        case EVENT_RATION_FOUND:
                            inventoryService.findRation(foundPlayerInventory);
                            break;
                        case EVENT_RESOURCES_FOUND:
                            inventoryService.findResources(foundPlayerInventory);
                            break;
                        case EVENT_TRAP:
                            inventoryService.fallIntoTrap(foundPlayerInventory);
                            break;
                        case EVENT_MONSTER_ATTACK:
                            System.out.println("No monster implemented yet");
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + eventTriggered);
                    }

                    return eventTriggered;
                }

            }
        } else {
            throw new PlayerNotFoundException(discordName);
        }

        throw new NoEventTriggeredException();

    }

    private int[] getEventProbabilitiesFromExploreEvent() {
        int[] eventProbabilities = new int[ExplorationEnum.values().length];
        for (int i = 0; i < ExplorationEnum.values().length; i++) {
            eventProbabilities[i] = ExplorationEnum.values()[i].getProbability();
        }
        return eventProbabilities;
    }


}
