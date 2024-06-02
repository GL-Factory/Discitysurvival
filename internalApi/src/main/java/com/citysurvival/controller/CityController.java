package com.citysurvival.controller;

import com.citysurvival.daos.CityRepository;
import com.citysurvival.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {

    @Autowired
    private CityRepository cityRepository;


    public void saveCity(City cityToSave){
        cityRepository.save(cityToSave);
    }

}
