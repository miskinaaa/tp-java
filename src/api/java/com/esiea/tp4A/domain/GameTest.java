package api.java.com.esiea.tp4A.domain;

import main.java.com.esiea.tp4A.domain.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameTest {
    private final PlanetMapImpl planetMapImpl = new PlanetMapImpl();
    private final MarsRoverImpl marsRoverImpl = new MarsRoverImpl();
    private final Set<Position> obstaclePositions = new HashSet<>();
    private final List<MarsRoverImpl> listPlayers =  new ArrayList<MarsRoverImpl>();

    public GameTest() {
        Game game = new Game();
        int mapGame = game.randomMapSize();
        System.out.println("map: " +mapGame);
        Set<Position> obstaclePositions = game.generateObstacles();
        game.randomPlayers();
        game.randomLaser();
        System.out.println("laser: "+game.randomLaser());
    }

    public static void main(String[] args){
        GameTest gt = new GameTest();
    }


}
