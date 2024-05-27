package com.citysurvival.daos;

import com.citysurvival.models.World;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldRepository extends CrudRepository<World, Integer> {


    World findByName(String worldName);

}
