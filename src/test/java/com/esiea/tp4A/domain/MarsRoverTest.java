package test.java.com.esiea.tp4A.domain;

import main.java.com.esiea.tp4A.domain.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MarsRoverTest {

    private MarsRoverImpl marsRover = new MarsRoverImpl();
    Grid grid = new Grid(100,100, marsRover);

    @Test
    void move_forward() {
        marsRover.initialize(Position.of(0,0, Direction.NORTH));
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
    void move_right_forward() {
        marsRover.initialize(Position.of(0,0,Direction.NORTH));
        marsRover.move("r");
        marsRover.move("f");
        assertEquals(marsRover.getX(), 1);
        assertEquals(marsRover.getY(), 0);
        assertEquals(marsRover.getDirection(), Direction.EAST);
    }

    @Test
    void move_left_forward() {
        marsRover.initialize(Position.of(0,0,Direction.NORTH));
        marsRover.move("l");
        marsRover.move("f");
        assertEquals(marsRover.getX(), -1);
        assertEquals(marsRover.getY(), 0);
        assertEquals(marsRover.getDirection(), Direction.WEST);
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

    @Test
    void add_obstacles_and_check_if_there_is_obstacle() {
        PlanetMapImpl planetMapImpl = new PlanetMapImpl();
        planetMapImpl.addObstacles(4, 6);
        boolean checkOb1 = planetMapImpl.isThereObstacles(Position.of(4, 6, Direction.NORTH));
        assertEquals(true, checkOb1);
        boolean checkOb2 = planetMapImpl.isThereObstacles(Position.of(7, 6, Direction.NORTH));
        assertEquals(false, checkOb2);
        marsRover.updateMap(planetMapImpl);
    }


    @Test
    void remove_the_obstacle() {
        PlanetMapImpl planetMapImpl = new PlanetMapImpl();
        planetMapImpl.addObstacles(4, 4);
        boolean obj = planetMapImpl.isThereObstacles(Position.of(4,4,Direction.NORTH));
        assertEquals(true,obj);
        boolean obj1 = planetMapImpl.removeObstacles(4, 4);
        assertEquals(false,obj1);
        marsRover.updateMap(planetMapImpl);
    }

    @Test
    void move_forward_with_obstacle() {
        PlanetMapImpl planetMapImpl = new PlanetMapImpl();
        planetMapImpl.addObstacles(0, 1);
        boolean checkObs = planetMapImpl.isThereObstacles(Position.of(0, 1, Direction.NORTH));
        marsRover.initialize(Position.of(0,0,Direction.NORTH));
        if(checkObs == true) {
            System.out.println("Command ignored");
        }
        else {
            marsRover.move("f");
        }
        assertEquals(marsRover.getX(), 0);
        assertEquals(marsRover.getY(), 0);
    }

    @Test
    void move_backward_with_obstacle() {
        PlanetMapImpl planetMapImpl = new PlanetMapImpl();
        planetMapImpl.addObstacles(0, -1);

        boolean checkObs = planetMapImpl.isThereObstacles(Position.of(0, -1, Direction.NORTH));

        marsRover.initialize(Position.of(0,0,Direction.NORTH));
        if(checkObs == true) {
            System.out.println("Command ignored");
        }
        else {
            marsRover.move("b");
        }
        assertEquals(marsRover.getX(), 0);
        assertEquals(marsRover.getY(), 0);
    }

    @Test
    void move_left_with_obstacle() {
        PlanetMapImpl planetMapImpl = new PlanetMapImpl();
        planetMapImpl.addObstacles(-1, 0);

        boolean checkObs = planetMapImpl.isThereObstacles(Position.of(-1, 0, Direction.NORTH));

        marsRover.initialize(Position.of(0,0,Direction.NORTH));
        if(checkObs == true) {
            System.out.println("Command ignored");
        }
        else {
            marsRover.move("l");
            marsRover.move("f");
        }
        assertEquals(marsRover.getX(), 0);
        assertEquals(marsRover.getY(), 0);
    }

    @Test
    void move_right_with_obstacle() {
        PlanetMapImpl planetMapImpl = new PlanetMapImpl();
        planetMapImpl.addObstacles(1, 0);

        boolean checkObs = planetMapImpl.isThereObstacles(Position.of(1, 0, Direction.NORTH));

        marsRover.initialize(Position.of(0,0,Direction.NORTH));
        if(checkObs == true) {
            System.out.println("Command ignored");
        }
        else {
            marsRover.move("r");
            marsRover.move("f");
        }
        assertEquals(marsRover.getX(), 0);
        assertEquals(marsRover.getY(), 0);
    }

}
