package com.citysurvival.gamecitysurvival.controller;

import com.citysurvival.gamecitysurvival.dto.CityDto;
import com.citysurvival.gamecitysurvival.exception.CityAlreadyExistException;
import com.citysurvival.gamecitysurvival.models.World;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class WorldController {

    private final World gameWorld = new World(new ArrayList<>());

    @PostMapping("/world/city/register")
    public ResponseEntity<?> registerCity(@RequestBody CityDto cityDto){
        try {
            gameWorld.newCity(cityDto.getCityName(), cityDto.getCityId());
            return ResponseEntity.ok().build();
        } catch (CityAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
