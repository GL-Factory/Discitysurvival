package com.citysurvival.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Table(name = "world")
@Entity
@Getter
@Setter
public class World {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="world")
    private Set<City> cities;


}
