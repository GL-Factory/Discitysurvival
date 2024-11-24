package com.citysurvival.configProperty;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix="player")
@Component
@Getter
@Setter
public class PlayerConfigProperty {
    private int baseEnergy;
}
