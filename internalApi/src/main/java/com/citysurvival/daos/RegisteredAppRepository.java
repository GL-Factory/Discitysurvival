package com.citysurvival.daos;

import com.citysurvival.models.RegisteredApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RegisteredAppRepository extends JpaRepository<RegisteredApp, Integer> {
    Optional<RegisteredApp> findByUsername(String username);
}
