package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlanetMapImplTest {
    private final PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);
    final MarsRoverImpl  marsRover = new MarsRoverImpl((Position.of(0, 0, Direction.NORTH)), planetMap);

    @Test
    public void init_map() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize(600);
        Assertions.assertThat(planetMapImpl).isEqualToComparingFieldByField((PlanetMapImpl) new PlanetMapImpl().initialize(600));
    }

    @Test
    public void planet_size(){
        PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);
        assertEquals(100, planetMap.getSIZE_OF_MAP());
    }


    @Test
    public void add_obstacles_and_check_if_there_is_obstacle() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(4, 6, Direction.NORTH));
        boolean checkOb1 = planetMapImpl.isThereObstacles(Position.of(4, 6, Direction.NORTH));
        assertEquals(true, checkOb1);
        boolean checkOb2 = planetMapImpl.isThereObstacles(Position.of(7, 6, Direction.NORTH));
        assertEquals(false, checkOb2);
    }

    @Test
    public void add_obstacles_twice() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        boolean checkOb1 = planetMapImpl.addObstacles(Position.of(4, 6, Direction.NORTH));
        boolean checkOb2 = planetMapImpl.addObstacles(Position.of(4, 6, Direction.NORTH));
        assertEquals(true, checkOb1);
        assertEquals(false, checkOb2);
    }

    @Test
    public void remove_the_obstacle() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        Position p = Position.of(4, 4, Direction.NORTH);
        planetMapImpl.addObstacles(p);
        boolean obj = planetMapImpl.isThereObstacles(p);
        assertEquals(true, obj);
        planetMapImpl.removeObstacles(p);
        assertEquals(0, planetMapImpl.getObstaclePositions().size());
    }

    @Test
    public void remove_obstacles_twice() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        Position position_obstacle = Position.of(1, 0, Direction.NORTH);
        planetMapImpl.addObstacles(position_obstacle);
        planetMapImpl.removeObstacles(position_obstacle);
        assertEquals(0, planetMapImpl.getObstaclePositions().size());
        planetMapImpl.removeObstacles(position_obstacle);
        assertEquals(0, planetMapImpl.getObstaclePositions().size());
    }

}
