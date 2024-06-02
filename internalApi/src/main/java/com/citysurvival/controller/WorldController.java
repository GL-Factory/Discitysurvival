package com.citysurvival.controller;

import com.citysurvival.daos.CityRepository;
import com.citysurvival.daos.WorldRepository;
import com.citysurvival.models.City;
import com.citysurvival.models.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class WorldController {


    @Autowired
    private WorldRepository worldRepository;

    public void initNewWorld() {
        if(!worldRepository.existsById(1)){
            World newWorld = new World();
            newWorld.setName("PremierMonde");
            worldRepository.save(newWorld);
        }
    }

    public void addCityToWorld(City cityToAdd){
        Optional<World> firstWorldOption = worldRepository.findById(1);

        if(firstWorldOption.isPresent()) {
            World firstWorld = firstWorldOption.get();

            Set<City> firstWorldCities = firstWorld.getCities();

            cityToAdd.setWorld(firstWorld);

            firstWorldCities.add(cityToAdd);

            firstWorld.setCities(firstWorldCities);

            worldRepository.save(firstWorld);
        }
    }

    public List<String> getAllCitiesForWorld(String worldName){
        List<World> foundWorld = worldRepository.findByName(worldName);
        if(foundWorld != null) {
            return foundWorld.get(0).getCities().stream().map(City::getName).toList();
        } else {
            return new ArrayList<>();
        }
    }

}
