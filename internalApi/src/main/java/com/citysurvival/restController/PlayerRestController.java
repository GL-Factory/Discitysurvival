package com.citysurvival.restController;

import com.citysurvival.controller.PlayerController;
import com.citysurvival.exception.PlayerAlreadyExistException;
import com.citysurvival.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerRestController {

    @Autowired
    private PlayerController playerController;


    @PostMapping("/leaveCity")
    public ResponseEntity<?> leaveCity(@RequestBody String playerDiscordName) {

        try {
            Player moovedPlayer = playerController.makePlayerLeaveCity(playerDiscordName);
            return ResponseEntity.ok().body(String.format("Player %s is now at location %s", playerDiscordName, moovedPlayer.getLocation()));
        } catch (PlayerAlreadyExistException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }

    }

    @PostMapping("/enterCity")
    public ResponseEntity<?> enterCity(@RequestBody String playerDiscordName) {

        try {
            Player moovedPlayer = playerController.makePlayerGoBackToCity(playerDiscordName);
            return ResponseEntity.ok().body(String.format("Player %s is now at location %s", playerDiscordName, moovedPlayer.getLocation()));
        } catch (PlayerAlreadyExistException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }


    @PostMapping("/explore")
    public ResponseEntity<?> explore(@RequestBody String playerDiscordName) {
        return ResponseEntity.ok().build();
    }

}
