package test.java.com.esiea.tp4A.domain;

import main.java.com.esiea.tp4A.domain.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MarsRoverTest {
    final MarsRover marsRover = new MarsRoverImpl().initialize(Position.of(0, 0, Direction.NORTH));
    final MarsRover marsRoverSouth = new MarsRoverImpl().initialize(Position.of(0, 0, Direction.SOUTH));
    final MarsRover marsRoverEast = new MarsRoverImpl().initialize(Position.of(0, 0, Direction.EAST));
    final MarsRover marsRoverWest = new MarsRoverImpl().initialize(Position.of(0, 0, Direction.WEST));



    @Test
    void move_error() {
        Position position_error = marsRover.move("");
        assertEquals(position_error.getX(), 0);
        assertEquals(position_error.getY(), 0);
        assertEquals(position_error.getDirection(), Direction.NORTH);
    }

    @Test
    void move_forward() {
        Position position_north = marsRover.move("f");
        assertEquals(position_north.getX(), 0);
        assertEquals(position_north.getY(), 1);
        assertEquals(position_north.getDirection(), Direction.NORTH);
    }

    @Test
    void move_backward() {
        Position position_south = marsRover.move("b");
        assertEquals(position_south.getX(), 0);
        assertEquals(position_south.getY(), -1);
        assertEquals(position_south.getDirection(), Direction.NORTH);
    }

    @Test
    void move_left() {
        Position position_west = marsRover.move("l");
        assertEquals(position_west.getX(), 0);
        assertEquals(position_west.getY(), 0);
        assertEquals(position_west.getDirection(), Direction.WEST);
    }

    @Test
    void move_right() {
        Position position_east = marsRover.move("r");
        assertEquals(position_east.getX(), 0);
        assertEquals(position_east.getY(), 0);
        assertEquals(position_east.getDirection(), Direction.EAST);
    }

    @Test
    void move_right_forward() {
        Position position_east_forward = marsRover.move("rf");
        assertEquals(position_east_forward.getX(), 1);
        assertEquals(position_east_forward.getY(), 0);
        assertEquals(position_east_forward.getDirection(), Direction.EAST);
    }

    @Test
    void move_left_forward() {
        Position position_west_forward = marsRover.move("lf");
        assertEquals(position_west_forward.getX(), -1);
        assertEquals(position_west_forward.getY(), 0);
        assertEquals(position_west_forward.getDirection(), Direction.WEST);
    }

    @Test
    void move_to_1_2_w() {
        Position position_west_forward = marsRover.move("fflb");
        assertEquals(position_west_forward.getX(), 1);
        assertEquals(position_west_forward.getY(), 2);
        assertEquals(position_west_forward.getDirection(), Direction.WEST);
    }


    @Test
    void moving_north_when_0_50_N() {
        final MarsRover marsRover = new MarsRoverImpl().initialize(Position.of(0, 50, Direction.NORTH));
        Position position_when_0_50_N = marsRover.move("f");
        assertEquals(-49, position_when_0_50_N.getY());
    }

    @Test
    void moving_east_when_50_0_E() {
        final MarsRover marsRover = new MarsRoverImpl().initialize(Position.of(50, 0, Direction.EAST));
        Position position_when_50_0_E = marsRover.move("f");
        assertEquals(-49, position_when_50_0_E.getX());
    }

    @Test
    void moving_south_when_0_minus_50_S() {
        final MarsRover marsRover = new MarsRoverImpl().initialize(Position.of(0, -50, Direction.SOUTH));
        Position position_when_0_minus_50_S = marsRover.move("f");
        assertEquals(49, position_when_0_minus_50_S.getY());
    }

    @Test
    void moving_west_when_minus_50_0_W() {
        final MarsRover marsRover = new MarsRoverImpl().initialize(Position.of(50, 0, Direction.WEST));
        Position position_when_minus_50_0_W = marsRover.move("f");
        assertEquals(49, position_when_minus_50_0_W.getX());
    }

    @Test
    void add_obstacles_and_check_if_there_is_obstacle() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(4, 6, Direction.NORTH));
        boolean checkOb1 = planetMapImpl.isThereObstacles(Position.of(4, 6, Direction.NORTH));
        assertEquals(true, checkOb1);
        boolean checkOb2 = planetMapImpl.isThereObstacles(Position.of(7, 6, Direction.NORTH));
        assertEquals(false, checkOb2);
    }

    @Test
    void add_obstacles_twice() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        boolean checkOb1 = planetMapImpl.addObstacles(Position.of(4, 6, Direction.NORTH));
        boolean checkOb2 = planetMapImpl.addObstacles(Position.of(4, 6, Direction.NORTH));
        assertEquals(true, checkOb1);
        assertEquals(false, checkOb2);
    }

    @Test
    void remove_the_obstacle() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(4, 4, Direction.NORTH));
        boolean obj = planetMapImpl.isThereObstacles(Position.of(4, 4, Direction.NORTH));
        assertEquals(true, obj);
        boolean obj1 = planetMapImpl.removeObstacles(Position.of(4,4,Direction.NORTH));
        assertEquals(false, obj1);
    }

    @Test
    void remove_obstacles_twice() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        Position position_obstacle = Position.of(1, 0, Direction.NORTH);
        planetMapImpl.addObstacles(position_obstacle);
        boolean checkOb1 = planetMapImpl.removeObstacles(position_obstacle);
        boolean checkOb2 = planetMapImpl.removeObstacles(position_obstacle);
        assertEquals(true, checkOb1);
        assertEquals(false, checkOb2);
    }

    @Test
    void move_forward_with_obstacle_north() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0, 1, Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_obstacles = marsRover.move("f");
        assertEquals(position_obstacles.getX(), 0);
        assertEquals(position_obstacles.getY(), 0);
        assertEquals(position_obstacles.getDirection(), Direction.NORTH);

    }

    @Test
    void move_forward_with_obstacle_south() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0, -1, Direction.SOUTH));
        marsRover.updateMap(planetMapImpl);
        Position position_obstacles = marsRoverSouth.move("f");
        assertEquals(position_obstacles.getX(), 0);
        assertEquals(position_obstacles.getY(), 0);
        assertEquals(position_obstacles.getDirection(), Direction.SOUTH);
    }


    @Test
    void move_forward_with_obstacle_east() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(1,0,Direction.EAST));
        marsRover.updateMap(planetMapImpl);
        Position position_obstacles = marsRoverEast.move("f");
        assertEquals(position_obstacles.getX(), 0);
        assertEquals(position_obstacles.getY(), 0);
        assertEquals(position_obstacles.getDirection(), Direction.EAST);
    }

    @Test
    void move_forward_with_obstacle_west() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(-1,0,Direction.WEST));
        marsRover.updateMap(planetMapImpl);
        Position position_obstacles = marsRoverWest.move("f");
        assertEquals(position_obstacles.getX(), 0);
        assertEquals(position_obstacles.getY(), 0);
        assertEquals(position_obstacles.getDirection(), Direction.WEST);
    }

    @Test
    void move_backward_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0,-1,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_obstacles = marsRover.move("b");
        assertEquals(position_obstacles.getX(), 0);
        assertEquals(position_obstacles.getY(), 0);
        assertEquals(position_obstacles.getDirection(), Direction.NORTH);
    }

    @Test
    void move_left_with_obstacle() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(-1,0,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_obstacles = marsRover.move("lf");
        assertEquals(position_obstacles.getX(), 0);
        assertEquals(position_obstacles.getY(), 0);
        assertEquals(position_obstacles.getDirection(),Direction.NORTH );
    }

    @Test
    void move_right_with_obstacle() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(1,0,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_obstacles = marsRover.move("rf");
        assertEquals(position_obstacles.getX(), 0);
        assertEquals(position_obstacles.getY(), 0);
        assertEquals(position_obstacles.getDirection(),Direction.NORTH );
    }

    @Test
    void move_f_f_f_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0,2,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_obstacles = marsRover.move("fff");
        assertEquals(position_obstacles.getX(), 0);
        assertEquals(1,position_obstacles.getY());
        assertEquals(position_obstacles.getDirection(), Direction.NORTH);
    }

    @Test
    void move_f_f_l_b_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0,1,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_obstacles = marsRover.move("fflb");
        assertEquals(position_obstacles.getX(), 1);
        assertEquals(position_obstacles.getY(), 0);
        //assertEquals(position_obstacles.getDirection(), Direction.EAST);
    }
}