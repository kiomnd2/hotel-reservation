package com.subprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@PropertySource(ignoreResourceNotFound = true, encoding = "UTF-8", value = {
        "classpath:config/application-hotelapi.properties"
})
@EnableDiscoveryClient
@SpringBootApplication
public class HotelApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotelApiApplication.class);
    }
}
