package com.citysurvival.services;

import com.citysurvival.daos.CityRepository;
import com.citysurvival.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;


    public void saveCity(City cityToSave) {
        cityRepository.save(cityToSave);
    }

}
