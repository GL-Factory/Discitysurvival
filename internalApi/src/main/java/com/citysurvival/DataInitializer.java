package com.citysurvival;

import com.citysurvival.configProperty.AdminUserProperties;
import com.citysurvival.daos.RegisteredAppRepository;
import com.citysurvival.daos.WorldRepository;
import com.citysurvival.models.RegisteredApp;
import com.citysurvival.models.World;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RegisteredAppRepository registeredAppRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminUserProperties adminProps;
    private final WorldRepository worldRepository;

    public DataInitializer(RegisteredAppRepository registeredAppRepository, PasswordEncoder passwordEncoder, WorldRepository worldRepository, AdminUserProperties adminProps) {
        this.registeredAppRepository = registeredAppRepository;
        this.passwordEncoder = passwordEncoder;
        this.worldRepository = worldRepository;
        this.adminProps = adminProps;
    }

    @Override
    public void run(String... args) throws Exception {
        if (registeredAppRepository.findByUsername(adminProps.getUsername()).isEmpty()) {
            RegisteredApp admin = new RegisteredApp();
            admin.setUsername(adminProps.getUsername());
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            registeredAppRepository.save(admin);
            System.out.println("Utilisateur admin créé avec succès");
        }

        if (worldRepository.findByName("PremierMonde").isEmpty()) {
            World firstWorld = new World();
            firstWorld.setName("Premier Monde");
            worldRepository.save(firstWorld);
            System.out.println("PremierMonde créé avec succès");
        }

    }
}