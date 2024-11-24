package com.citysurvival.services;

import com.citysurvival.configProperty.PlayerConfigProperty;
import com.citysurvival.daos.CityRepository;
import com.citysurvival.daos.InventoryRepository;
import com.citysurvival.daos.PlayerRepository;
import com.citysurvival.daos.WorldRepository;
import com.citysurvival.exception.CityNotFoundForWorldException;
import com.citysurvival.exception.PlayerAlreadyExistException;
import com.citysurvival.exception.WorldNotFoundException;
import com.citysurvival.models.City;
import com.citysurvival.models.Inventory;
import com.citysurvival.models.Player;
import com.citysurvival.models.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WorldService {


    @Autowired
    private WorldRepository worldRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    private PlayerConfigProperty playerConfigProperty;

    public void initNewWorld() {
        if (!worldRepository.existsById(1)) {
            World newWorld = new World();
            newWorld.setName("PremierMonde");
            worldRepository.save(newWorld);
        }
    }

    public void addCityToWorld(City cityToAdd) {
        Optional<World> firstWorldOption = worldRepository.findById(1);

        if (firstWorldOption.isPresent()) {
            World firstWorld = firstWorldOption.get();

            Set<City> firstWorldCities = firstWorld.getCities();

            cityToAdd.setWorld(firstWorld);

            firstWorldCities.add(cityToAdd);

            firstWorld.setCities(firstWorldCities);

            worldRepository.save(firstWorld);
        }
    }

    public List<String> getAllCitiesForWorld(String worldName) {
        List<World> foundWorld = worldRepository.findByName(worldName);
        if (foundWorld != null) {
            return foundWorld.get(0).getCities().stream().map(City::getName).toList();
        } else {
            return new ArrayList<>();
        }
    }


    public Player addPlayerToCityForWorld(String discordName, String displayName, String cityName, String worldName) {

        City expectedCity;

        expectedCity = findCity(cityName, worldName);

        Player existingPlayer = playerRepository.findByDiscordName(discordName);

        if (existingPlayer != null) {
            throw new PlayerAlreadyExistException(discordName);
        } else {
            Player newPlayer = new Player();
            newPlayer.setDiscordName(discordName);
            newPlayer.setDisplayName(displayName);
            newPlayer.setCity(expectedCity);
            Inventory playerInventory = new Inventory();
            playerInventory = inventoryRepository.save(playerInventory);
            newPlayer.setInventory(playerInventory);
            newPlayer.setLocation("In Town");
            newPlayer.setMaxEnergy(playerConfigProperty.getBaseEnergy());
            newPlayer.setCurrentEnergy(playerConfigProperty.getBaseEnergy());
            newPlayer.setHasDrink(false);
            newPlayer.setHasEaten(false);
            playerRepository.save(newPlayer);
            return newPlayer;
        }
    }


    public City findCity(String cityName, String worldName) {

        List<World> foundWorld = worldRepository.findByName(worldName);

        if (foundWorld != null) {
            Optional<City> expectedCity = foundWorld.get(0).getCities().stream().filter(city -> city.getName().equals(cityName)).findFirst();

            if (expectedCity.isPresent()) {
                return expectedCity.get();
            } else {
                throw new CityNotFoundForWorldException(cityName, worldName);
            }

        } else {
            throw new WorldNotFoundException(worldName);
        }
    }

}
