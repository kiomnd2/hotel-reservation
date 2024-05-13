package com.subprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@PropertySource(ignoreResourceNotFound = true, encoding = "UTF-8", value = {
        "classpath:config/application-reservationapi.properties",
        "classpath:config/application-reservationapi-${spring.active.profiles}.properties"
})
@EnableDiscoveryClient
@SpringBootApplication
public class ReservationApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationApiApplication.class);
    }
}
