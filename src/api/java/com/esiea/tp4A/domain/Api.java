package api.java.com.esiea.tp4A.domain;
import main.java.com.esiea.tp4A.domain.*;
import java.util.Set;

public interface Api {

    Position getPosition(String playerName);

    Set<Position> getObstaclesPlayers(String playerName);

    int getLaserRange(String playerName);

    Position movePlayer(String playerName , String command);

    void laserShoot(String playerName);

    boolean isPlayerAlive(String playerName);

}

