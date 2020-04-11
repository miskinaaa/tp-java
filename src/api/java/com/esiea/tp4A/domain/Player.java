package api.java.com.esiea.tp4A.domain;

import main.java.com.esiea.tp4A.domain.Position;

import java.util.Set;

public interface Player {

    Player initialize(Api game, String playerName);

    Position getPosition();

    Set<Position> getObstaclesPlayers();

    int getLaserRange();

    Position move(String command);

    boolean isAlive();
}
