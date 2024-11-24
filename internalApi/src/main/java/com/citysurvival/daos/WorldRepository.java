package com.citysurvival.daos;

import com.citysurvival.models.World;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorldRepository extends JpaRepository<World, Integer> {


    List<World> findByName(String worldName);

}
