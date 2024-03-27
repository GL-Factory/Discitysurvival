package com.citysurvival.gamecitysurvival;

import com.citysurvival.gamecitysurvival.config.DBConfig;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class GamecitysurvivalApplication {


	public static void main(String[] args) {
		SpringApplication.run(GamecitysurvivalApplication.class, args);
	}

}
