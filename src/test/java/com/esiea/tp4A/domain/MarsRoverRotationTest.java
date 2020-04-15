package com.esiea.tp4A.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverRotationTest {
    private final PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);
    final MarsRoverImpl  marsRover = new MarsRoverImpl((Position.of(0, 0, Direction.NORTH)), planetMap);
    final MarsRoverImpl  marsRoverSouth = new MarsRoverImpl((Position.of(0, 0, Direction.SOUTH)), planetMap);
    final MarsRoverImpl  marsRoverEast = new MarsRoverImpl((Position.of(0, 0, Direction.EAST)), planetMap);
    final MarsRoverImpl  marsRoverWest = new MarsRoverImpl((Position.of(0, 0, Direction.WEST)), planetMap);

    @Test
    public void rotate_left_NORTH() {
        Position position = marsRover.move("l");
        assertEquals( 0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Direction.WEST, position.getDirection());
    }
    @Test
    public void rotate_left_SOUTH() {
        Position position = marsRoverSouth.move("l");
        assertEquals( 0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Direction.EAST, position.getDirection());
    }

    @Test
    public void rotate_left_EAST() {
        Position position = marsRoverEast.move("l");
        assertEquals( 0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Direction.NORTH, position.getDirection());
    }
    @Test
    public void rotate_left_WEST() {
        Position position = marsRoverWest.move("l");
        assertEquals( 0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Direction.SOUTH, position.getDirection());
    }

    @Test
    public void rotate_right_NORTH() {
        Position position = marsRover.move("r");
        assertEquals( 0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Direction.EAST, position.getDirection());
    }
    @Test
    public void rotate_right_SOUTH() {
        Position position = marsRoverSouth.move("r");
        assertEquals( 0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Direction.WEST, position.getDirection());
    }

    @Test
    public void rotate_right_EAST() {
        Position position = marsRoverEast.move("r");
        assertEquals( 0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Direction.SOUTH, position.getDirection());
    }
    @Test
    public void rotate_right_WEST() {
        Position position = marsRoverWest.move("r");
        assertEquals( 0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Direction.NORTH, position.getDirection());
    }
}
