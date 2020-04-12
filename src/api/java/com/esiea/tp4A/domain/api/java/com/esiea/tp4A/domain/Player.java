package api.java.com.esiea.tp4A.domain;

import main.java.com.esiea.tp4A.domain.Position;

import java.util.Set;

public interface Player {

    default Player initialize(Api game, String playerName);

    default Position getPosition();

    default Set<Position> getObstaclesPlayers();

    default int getLaserRange();

    default Position move(String command);

    default boolean isAlive();
}
