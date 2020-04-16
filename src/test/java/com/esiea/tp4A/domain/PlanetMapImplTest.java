package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlanetMapImplTest {
    private final PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);
    final MarsRoverImpl  marsRover = new MarsRoverImpl((Position.of(0, 0, Direction.NORTH)), planetMap);
    final MarsRoverImpl  marsRoverSouth = new MarsRoverImpl((Position.of(0, 0, Direction.SOUTH)), planetMap);
    final MarsRoverImpl  marsRoverEast = new MarsRoverImpl((Position.of(0, 0, Direction.EAST)), planetMap);
    final MarsRoverImpl  marsRoverWest = new MarsRoverImpl((Position.of(0, 0, Direction.WEST)), planetMap);

    @Test
    public void init_map() {
        PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);
        Assertions.assertThat(planetMap).isEqualToComparingFieldByField((PlanetMapImpl) new PlanetMapImpl().initialize(100));
    }

    @Test
    public void get_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0, 1, Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        assertEquals(1, planetMapImpl.getObstaclePositions().size());

    }

    @Test
    public void position_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0, 1, Direction.NORTH));
        planetMapImpl.addObstacles(Position.of(1, 0, Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        assertEquals(2, planetMapImpl.obstaclePositions().size());
    }

    @Test
    public void set_position_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.setObstaclePositions(planetMapImpl.obstaclePositions());
        marsRover.updateMap(planetMapImpl);
        assertEquals(0, planetMapImpl.obstaclePositions().size());
    }
}
