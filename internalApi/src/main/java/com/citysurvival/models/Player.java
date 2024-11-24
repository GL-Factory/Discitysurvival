package com.citysurvival.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "player")
@Entity
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String discordName;

    private String displayName;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name="city_id", nullable=false)
    private City city;

    private String location;

    private int maxEnergy;

    private int currentEnergy;

    private boolean hasDrink;

    private boolean hasEaten;
}
