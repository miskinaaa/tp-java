package com.esiea.tp4A.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverDeplacementTest {
    private final PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);

    @Test
    public void moving_north_when_0_50_N() {
        final MarsRover marsRover = new MarsRoverImpl((Position.of(0, 50, Direction.NORTH)), planetMap);
        Position position_when_0_50_N = marsRover.move("f");
        assertEquals(-49, position_when_0_50_N.getY());
    }

    @Test
    public void moving_east_when_50_0_E() {
        final MarsRover marsRover = new MarsRoverImpl((Position.of(50, 0, Direction.EAST)), planetMap);
        Position position_when_50_0_E = marsRover.move("f");
        assertEquals(-49, position_when_50_0_E.getX());
    }

    @Test
    public void moving_south_when_0_minus_50_S() {
        final MarsRover marsRover = new MarsRoverImpl((Position.of(0, -50, Direction.SOUTH)), planetMap);
        Position position_when_0_minus_50_S = marsRover.move("f");
        assertEquals(49, position_when_0_minus_50_S.getY());
    }

    @Test
    public void moving_west_when_minus_50_0_W() {
        final MarsRover marsRover = new MarsRoverImpl((Position.of(50, 0, Direction.WEST)), planetMap);
        Position position_when_minus_50_0_W = marsRover.move("f");
        assertEquals(49, position_when_minus_50_0_W.getX());
    }
}
