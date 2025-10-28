package edu.eci.arsw.WebSokets.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
@EnableScheduling
public class WSConfigurator {
    
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        try {
            Class.forName("jakarta.websocket.server.ServerContainer");
            return new ServerEndpointExporter();
        } catch (ClassNotFoundException e) {
            // No hay servidor web en el entorno de test
            return null;
        }
    }

}