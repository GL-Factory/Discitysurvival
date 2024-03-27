package com.citysurvival.gamecitysurvival.models;

import com.citysurvival.gamecitysurvival.exception.CityAlreadyExistException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class World {
    private List<City> cityList;

    public void newCity(String cityName, String cityId) {
        if(cityList.stream().noneMatch(c -> c.getId().equals(cityId) && c.getName().equals(cityName))){
            cityList.add(new City(cityId, cityName, new ArrayList<>(), new Inventory(0,0,0,0,0)));
        } else {
            throw new CityAlreadyExistException();
        }
    }
}
