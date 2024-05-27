package com.citysurvival.restController;

import com.citysurvival.controller.WorldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameRestController {

    @Autowired
    private WorldController worldController;


    @PostMapping("/game/initWorld")
    public ResponseEntity<?> startTheWorld() {

        worldController.initNewWorld();
        return ResponseEntity.ok().build();
    }
}
