package com.citysurvival.restController;

import com.citysurvival.controller.WorldController;
import com.citysurvival.dto.CityCreateDto;
import com.citysurvival.dto.PlayerRegisterDto;
import com.citysurvival.exception.CityNotFoundForWorldException;
import com.citysurvival.exception.PlayerAlreadyExistException;
import com.citysurvival.exception.WorldNotFoundException;
import com.citysurvival.models.City;
import com.citysurvival.models.Player;
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
    public ResponseEntity<?> registerCity(@RequestBody CityCreateDto cityDto) {
        City cityToAdd = new City();
        cityToAdd.setName(cityDto.getCityName());
        worldController.addCityToWorld(cityToAdd);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/city/list")
    public ResponseEntity<?> listCities(@RequestBody String worldName) {
        List<String> cities = worldController.getAllCitiesForWorld(worldName);
        return ResponseEntity.ok().body(cities);
    }

    @PostMapping("/player/register")
    public ResponseEntity<?> registerPlayer(@RequestBody PlayerRegisterDto playerRegisterDto) {
        try {
            Player createdPlayer = worldController.addPlayerToCityForWorld(playerRegisterDto.getDiscordName(), playerRegisterDto.getDisplayName(), playerRegisterDto.getCityName(), playerRegisterDto.getWorldName());
            return ResponseEntity.ok().build();

        } catch (WorldNotFoundException | CityNotFoundForWorldException | PlayerAlreadyExistException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }

    }
}
