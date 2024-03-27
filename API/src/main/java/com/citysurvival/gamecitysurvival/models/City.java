package com.citysurvival.gamecitysurvival.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class City {
    private String id;
    private String name;
    private List<Player> playerList;
    private Inventory cityInventory;


    public void enrollNewPlayer(String playerName) {
        if (!this.isEnrolledPlayer(playerName)) {
            Player newPlayer = new Player(playerName);
            playerList.add(newPlayer);
        }
    }

    private boolean isEnrolledPlayer(String playerName) {
        return playerList.stream().anyMatch(player -> player.getName().equals(playerName));
    }

    private Player getEnrolledPlayer(String playerName) {
        return playerList.stream()
                .filter(player -> player.getName().equals(playerName))
                .findFirst()
                .orElse(null);
    }

    public void leaveCityFor(String playerName) {
        if (isEnrolledPlayer(playerName)) {
            Player p = getEnrolledPlayer(playerName);
            p.getOut();
        }
    }
}
