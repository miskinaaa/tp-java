package api.java.com.esiea.tp4A.domain;
import main.java.com.esiea.tp4A.domain.*;
import main.java.com.esiea.tp4A.domain.Direction;
import main.java.com.esiea.tp4A.domain.MarsRoverImpl;
import main.java.com.esiea.tp4A.domain.PlanetMapImpl;
import main.java.com.esiea.tp4A.domain.Position;
import java.util.*;

public class ApiImpl implements Api {
    private Set<MarsRoverImpl> marsRovers;
    private final int laserRange;
    private final int mapSize;
    private final Set<Position> obstacles;

    public ApiImpl(int mapSize, Set<Position> obstacles, int laserRange) {
        RandomGame randomGame = new RandomGame();
        this.mapSize = randomGame.randomMapSize();
        this.obstacles = randomGame.generateObstacles();
        this.laserRange = randomGame.randomLaser();
        this.marsRovers = new HashSet<>();
    }

    MarsRoverImpl findRover(String playerName) {
        for (Iterator<MarsRoverImpl> marsRoverIterator = marsRovers.iterator(); marsRoverIterator.hasNext(); ) {
            MarsRoverImpl marsRover = marsRoverIterator.next();
            if (marsRover.getPlayerName().equals(playerName)) {
                return marsRover;
            }
        }
        return null;
    }

    @Override
    public Position getPosition(String playerName) {
        return findRover(playerName).getPosition();
    }
    @Override
    public Set<Position> getObstaclesPlayers(String playerName) {
        return null;
    }
    @Override
    public int getLaserRange(String playerName) {
        return laserRange;
    }
    @Override
    public Position movePlayer(String playerName, String command) {
        return findRover(playerName).getPosition();
    }
    @Override
    public void laserShoot(String playerName) {
        Position playerPosition = findRover(playerName).getPosition();
        findRover(playerName).getLaserRange();
    }
    @Override
    public boolean isPlayerAlive(String playerName) {
        return false;
    }
}
