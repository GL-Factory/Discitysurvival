package com.citysurvival.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "registeredApp")
@Entity
@Getter
@Setter
public class RegisteredApp {

    @Id
    @GeneratedValue
    private int id;

    private String username;

    private String password;

}
