package edu.eci.arsw.WebSokets.components;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import edu.eci.arsw.WebSokets.endpoints.TimerEndpoint;

@Component
@Scope("singleton")
public class TimedMessageBroker {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final Logger logger = Logger.getLogger(TimedMessageBroker.class.getName());

    @Scheduled(fixedRate = 5000)
    public void broadcast(){
        logger.log(Level.INFO, "broadcastingMessages");
        TimerEndpoint.send("The time is now :" + sdf.format(new Date()));
    }
}
