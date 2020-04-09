package api.java.com.esiea.tp4A.domain;

import main.java.com.esiea.tp4A.domain.MarsRover;
import main.java.com.esiea.tp4A.domain.Position;

public class ApiImpl implements Api {
    @Override
    public Position getPosition(String player) {
        return null;
    }

    @Override
    public MarsRover getObstaclesPlayers(String player) {
        return null;
    }

    @Override
    public int getLaserRange() {
        return 0;
    }

    @Override
    public Position movePlayer(String player, String command) {
        return null;
    }

    @Override
    public void laserShoot(String player) {

    }

    @Override
    public boolean isPlayerAlive(String player) {
        return false;
    }
}
