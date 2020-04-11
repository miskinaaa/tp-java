package api.java.com.esiea.tp4A.domain;

import main.java.com.esiea.tp4A.domain.*;
import main.java.com.esiea.tp4A.domain.Direction;
import main.java.com.esiea.tp4A.domain.MarsRoverImpl;
import main.java.com.esiea.tp4A.domain.PlanetMapImpl;
import main.java.com.esiea.tp4A.domain.Position;
import java.util.*;

public class ApiImpl implements Api {

    public ApiImpl() {
    }

    @Override
    public Api initialize(Game game, String playerName) {
        return null;
    }

    @Override
    public Position getPosition(String playerName) {
        return null;
    }

    @Override
    public Set<Position> getObstaclesPlayers(String playerName) {
        return null;
    }

    @Override
    public int getLaserRange(String playerName) {
        return 0;
    }

    @Override
    public Position movePlayer(String playerName, String command) {
        return null;
    }

    @Override
    public void laserShoot(String playerName) {

    }

    @Override
    public boolean isPlayerAlive(String playerName) {
        return false;
    }
}