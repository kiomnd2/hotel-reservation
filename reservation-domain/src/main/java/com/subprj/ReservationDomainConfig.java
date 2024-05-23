package com.subprj;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource(ignoreResourceNotFound = true, encoding = "UTF-8", value = {
        "classpath:config/application-reservation.properties"
})
@Configuration
public class ReservationDomainConfig {
}
