package edu.eci.arsw.WebSokets.endpoints;

import java.io.IOException;
import java.util.logging.Level;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/timer")
public class TimerEndpoint {
    private static final Logger logger = Logger.getLogger("ETFEndpoint");

    static Queue<Session> queue = new ConcurrentLinkedQueue<>();

    /* Enviar mensaje a todos los clientes conectados */
    public static void send(String msg) {
        try {
            for (Session session : queue) {
                session.getBasicRemote().sendText(msg);
                logger.log(Level.INFO, "Sent: {0}", msg);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.toString());
        }

    }

    /* Manejo de eventos de conexion, desconexion y errores */
    @OnOpen
    public void openConnection(Session session) {
        queue.add(session);
        logger.log(Level.INFO, "Connection opened");
        try {
            session.getBasicRemote().sendText("Connection established");
        } catch (IOException ex) {
            Logger.getLogger(TimerEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Manejo de eventos de cierre de conexion */
    @OnClose
    public void closedConnection(Session session) {
        queue.remove(session);
        logger.log(Level.INFO, "Connection closed");
    }

    /* Manejo de eventos de error */
    @OnError
    public void error(Session session, Throwable t) {
        queue.remove(session);
        logger.log(Level.SEVERE, "Connection error", t);
    }

}