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

    private String name;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name="city_id", nullable=false)
    private City city;

    private String location;

}
