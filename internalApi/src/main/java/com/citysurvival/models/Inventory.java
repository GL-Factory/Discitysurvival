package com.citysurvival.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "inventory")
@Entity
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue
    private int id;

    private int water;

    private int food;

    private int kit;

    private int wood;

    private int rock;

}
