package com.esiea.tp4A.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    private MarsRoverImpl marsRover = new MarsRoverImpl();

    @Test
    void move_forward() {
        marsRover.initialize(Position.of(0,0,Direction.NORTH));
        marsRover.move("f");
        assertEquals(marsRover.getX(), 0);
        assertEquals(marsRover.getY(), 1);
        assertEquals(marsRover.getDirection(), Direction.NORTH);
    }

    @Test
    void move_backward() {
        marsRover.initialize(Position.of(0,0,Direction.NORTH));
        marsRover.move("b");
        assertEquals(marsRover.getX(), 0);
        assertEquals(marsRover.getY(), -1);
        assertEquals(marsRover.getDirection(), Direction.NORTH);
    }

    @Test
    void move_left() {
        marsRover.initialize(Position.of(0,0,Direction.NORTH));
        marsRover.move("l");
        assertEquals(marsRover.getX(), 0);
        assertEquals(marsRover.getY(), 0);
        assertEquals(marsRover.getDirection(), Direction.WEST);
    }

    @Test
    void move_right() {
        marsRover.initialize(Position.of(0,0,Direction.NORTH));
        marsRover.move("r");
        assertEquals(marsRover.getX(), 0);
        assertEquals(marsRover.getY(), 0);
        assertEquals(marsRover.getDirection(), Direction.EAST);
    }
}
