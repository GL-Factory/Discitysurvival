package com.citysurvival.restController;

import com.citysurvival.controller.WorldController;
import com.citysurvival.dto.CityDto;
import com.citysurvival.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/world")
public class WorldRestController {

    @Autowired
    private WorldController worldController;


    @PostMapping("/city/register")
    public ResponseEntity<?> registerCity(@RequestBody CityDto cityDto){
            City cityToAdd = new City();
            cityToAdd.setName(cityDto.getCityName());
            worldController.addCityToWorld(cityToAdd);
            return ResponseEntity.ok().build();

    }


    @PostMapping("/city/list")
    public ResponseEntity<?> listCities(@RequestBody String worldName){
        List<String> cities = worldController.getAllCitiesForWorld(worldName);
        return ResponseEntity.ok().body(cities);
    }

    @PostMapping("/player/register")
    public ResponseEntity<?> registerPlayer(){
        return ResponseEntity.ok().build();
    }
}
