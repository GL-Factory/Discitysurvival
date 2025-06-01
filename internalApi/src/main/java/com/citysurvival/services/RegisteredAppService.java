package com.citysurvival.services;

import com.citysurvival.daos.RegisteredAppRepository;
import com.citysurvival.models.RegisteredApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegisteredAppService {

    @Autowired
    RegisteredAppRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public RegisteredApp createUser(String username, String rawPassword) {
        RegisteredApp registeredApp = new RegisteredApp();
        registeredApp.setUsername(username);
        registeredApp.setPassword(passwordEncoder.encode(rawPassword));
        return userRepository.save(registeredApp);
    }
}
