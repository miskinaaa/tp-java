package com.esiea.tp4A.api;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.PlanetMapImpl;
import com.esiea.tp4A.domain.Position;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGameTest {
    private final RandomGame randomGame = new RandomGame();

    @Test
    public void randomMapSize() {
        int randomMapSize = randomGame.randomMapSize();
        assertThat(randomMapSize).isIn(100,300,600);
    }

    @Test
    public void randomDirection() {
        Direction randomDirection = randomGame.randomDirection();
        assertThat(randomDirection).isIn(Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH);
    }

    @Test
    public void randomPosition() {
        PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);
        Position randomPosition = randomGame.randomPosition();
        assertThat(randomPosition.getX()).isBetween(-50, 50);
        assertThat(randomPosition.getY()).isBetween(-50, 50);
    }

    @Test
    public void generateObstacles() {
        PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);
        assertThat(randomGame.generateObstacles().size()).isEqualTo(15);
    }

    @Test
    public void randomPlayers() {
        PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);
        assertThat(randomGame.randomPlayers().size()).isEqualTo(50);
    }

    @Test
    public void randomLaser() {
        int randomLaser = randomGame.randomLaser();
        assertThat(randomLaser).isIn(5,30,1000);
    }
}
