package dev.joshtaylor.healthrouteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Properties;

@SpringBootApplication
@EntityScan("dev.joshtaylor.healthrouteapi.domain")
public class HealthRouteApiApplication
{

    public static void main (String[] args)
    {

        SpringApplication.run(HealthRouteApiApplication.class, args);
    }

}
