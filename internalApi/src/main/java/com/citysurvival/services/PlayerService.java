package com.citysurvival.services;

import com.citysurvival.daos.PlayerRepository;
import com.citysurvival.exception.PlayerAlreadyAtLocationException;
import com.citysurvival.exception.PlayerAlreadyExistException;
import com.citysurvival.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;


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
            throw new PlayerAlreadyExistException(discordName);
        }
    }


    

}
