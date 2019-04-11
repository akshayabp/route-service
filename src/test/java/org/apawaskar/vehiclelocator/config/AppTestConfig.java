package org.apawaskar.vehiclelocator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"org.apawaskar.vehiclelocator.services", "org.apawaskar.vehiclelocator.repos"})
public class AppTestConfig {

}
