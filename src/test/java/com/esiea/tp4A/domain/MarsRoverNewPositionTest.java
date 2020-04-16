package com.esiea.tp4A.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverNewPositionTest {
    private final PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);
    final MarsRoverImpl  marsRover = new MarsRoverImpl((Position.of(0, 0, Direction.NORTH)), planetMap);
    final MarsRoverImpl  marsRoverSouth = new MarsRoverImpl((Position.of(0, 0, Direction.SOUTH)), planetMap);
    final MarsRoverImpl  marsRoverEast = new MarsRoverImpl((Position.of(0, 0, Direction.EAST)), planetMap);
    final MarsRoverImpl  marsRoverWest = new MarsRoverImpl((Position.of(0, 0, Direction.WEST)), planetMap);


    @Test
    public void move_forward_NORTH() {
        Position position = marsRover.move("f");
        assertEquals( 0, position.getX());
        assertEquals(1, position.getY());
        assertEquals(Direction.NORTH, position.getDirection());
    }
    @Test
    public void move_backward_SOUTH() {
        Position position = marsRoverSouth.move("b");
        assertEquals( 0, position.getX());
        assertEquals(1, position.getY());
        assertEquals(Direction.SOUTH, position.getDirection());
    }

    @Test
    public void move_right_WEST() {
        Position position_north = marsRoverWest.move("r");
        assertEquals( 0, position_north.getX());
        assertEquals(0, position_north.getY());
        assertEquals(Direction.NORTH, position_north.getDirection());
    }
    @Test
    public void move_left_EAST() {
        Position position_north = marsRoverEast.move("l");
        assertEquals( 0, position_north.getX());
        assertEquals(0, position_north.getY());
        assertEquals(Direction.NORTH, position_north.getDirection());
    }

    @Test
    public void move_forward_SOUTH() {
        Position position_north = marsRoverSouth.move("f");
        assertEquals( 0, position_north.getX());
        assertEquals(-1, position_north.getY());
        assertEquals(Direction.SOUTH, position_north.getDirection());
    }
    @Test
    public void move_backward_NORTH() {
        Position position_north = marsRover.move("b");
        assertEquals( 0, position_north.getX());
        assertEquals(-1, position_north.getY());
        assertEquals(Direction.NORTH, position_north.getDirection());
    }

    @Test
    public void move_right_EAST() {
        Position position_north = marsRoverEast.move("r");
        assertEquals( 0, position_north.getX());
        assertEquals(0, position_north.getY());
        assertEquals(Direction.SOUTH, position_north.getDirection());
    }
    @Test
    public void move_left_WEST() {
        Position position_north = marsRoverWest.move("l");
        assertEquals( 0, position_north.getX());
        assertEquals(0, position_north.getY());
        assertEquals(Direction.SOUTH, position_north.getDirection());
    }

    @Test
    public void move_forward_EAST() {
        Position position_north = marsRoverEast.move("f");
        assertEquals( 1, position_north.getX());
        assertEquals(0, position_north.getY());
        assertEquals(Direction.EAST, position_north.getDirection());
    }
    @Test
    public void move_backward_WEST() {
        Position position_north = marsRoverWest.move("b");
        assertEquals( 1, position_north.getX());
        assertEquals(0, position_north.getY());
        assertEquals(Direction.WEST, position_north.getDirection());
    }
}
