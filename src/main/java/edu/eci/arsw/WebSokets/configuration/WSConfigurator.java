package edu.eci.arsw.WebSokets.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
@EnableScheduling
public class WSConfigurator {
    
    @Bean   
    @Profile("!test") // no se cargará en los tests
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}