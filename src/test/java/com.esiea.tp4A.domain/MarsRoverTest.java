package main.java.com.esiea.tp4A.domain;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

    private MarsRoverImpl marsRover = new MarsRoverImpl();
    Grid grid = new Grid(100,100, marsRover);

    @Test
    void move_forward() {
        marsRover.initialize(Position.of(0,0,Direction.NORTH));
        marsRover.move("f");
        grid.newCordo(0,1);
        assertEquals(marsRover.getX(), 0);
        assertEquals(marsRover.getY(), 1);
        assertEquals(marsRover.getDirection(), Direction.NORTH);
        assertEquals(1, grid.getY());
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

    @Test
    void moving_north_when_0_50_N() {
        marsRover.initialize(Position.of(0,50,Direction.NORTH));
        marsRover.move("f");
        grid.newCordo(0,-49);
        marsRover.initialize(Position.of(grid.getX(),grid.getY(),Direction.NORTH));
        assertEquals(-49, grid.getY());
    }
    @Test
    void moving_east_when_50_0_E() {
        marsRover.initialize(Position.of(50,0,Direction.EAST));
        marsRover.move("f");
        grid.newCordo(-49,-0);
        marsRover.initialize(Position.of(grid.getX(),grid.getY(),Direction.NORTH));
        assertEquals(-49, grid.getX());
    }
    @Test
    void moving_south_when_0_minus_50_S() {
        marsRover.initialize(Position.of(0,-50,Direction.SOUTH));
        marsRover.move("f");
        grid.newCordo(0,49);
        marsRover.initialize(Position.of(grid.getX(),grid.getY(),Direction.NORTH));
        assertEquals(49, grid.getY());
    }
    @Test
    void moving_west_when_minus_50_0_W() {
        marsRover.initialize(Position.of(-50,0,Direction.WEST));
        marsRover.move("f");
        grid.newCordo(50,0);
        marsRover.initialize(Position.of(grid.getX(),grid.getY(),Direction.NORTH));
        assertEquals(50, grid.getX());
    }
}
