package edu.eci.arsw.WebSokets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/status")
    public String getStatus() {
        return "{\"status\":\"Greetings from Spring Boot "
                + java.time.LocalDate.now() + ", " 
                + java.time.LocalTime.now() 
                + ". " + "The server is running!\"}";
    }
}
