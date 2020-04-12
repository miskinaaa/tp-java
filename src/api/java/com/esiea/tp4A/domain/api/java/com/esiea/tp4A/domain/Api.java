package api.java.com.esiea.tp4A.domain;

import main.java.com.esiea.tp4A.domain.*;

import java.util.Set;

public interface Api {

    default Position getPosition(String playerName);

    default Set<Position> getObstaclesPlayers(String playerName);

    default int getLaserRange(String playerName);

    default Position movePlayer(String playerName, String command);

    default void laserShoot(String playerName);

    default boolean isPlayerAlive(String playerName);

}

