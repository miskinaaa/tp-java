package com.esiea.tp4A.domain;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import com.esiea.tp4A.domain.*;


public class MarsRoverTest {
    final MarsRoverImpl  marsRover = (MarsRoverImpl) new MarsRoverImpl().initialize(Position.of(0, 0, Direction.NORTH));
    final MarsRoverImpl  marsRoverSouth = (MarsRoverImpl) new MarsRoverImpl().initialize(Position.of(0, 0, Direction.SOUTH));
    final MarsRoverImpl  marsRoverEast = (MarsRoverImpl) new MarsRoverImpl().initialize(Position.of(0, 0, Direction.EAST));
    final MarsRoverImpl  marsRoverWest = (MarsRoverImpl) new MarsRoverImpl().initialize(Position.of(0, 0, Direction.WEST));


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
        Position p = Position.of(4, 4, Direction.NORTH);
        planetMapImpl.addObstacles(p);
        boolean obj = planetMapImpl.isThereObstacles(p);
        assertEquals(true, obj);
        planetMapImpl.removeObstacles(p);
        assertEquals(0, planetMapImpl.getObstaclePositions().size());
    }

    @Test
    void remove_obstacles_twice() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        Position position_obstacle = Position.of(1, 0, Direction.NORTH);
        planetMapImpl.addObstacles(position_obstacle);
        planetMapImpl.removeObstacles(position_obstacle);
        assertEquals(0, planetMapImpl.getObstaclePositions().size());
        planetMapImpl.removeObstacles(position_obstacle);
        assertEquals(0, planetMapImpl.getObstaclePositions().size());
    }

    @Test
    void move_forward_with_obstacle_north() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0, 1, Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("f");
        assertEquals(position_rover.getX(), 0);
        assertEquals(position_rover.getY(), 0);
        assertEquals(position_rover.getDirection(), Direction.NORTH);

    }

    @Test
    void move_forward_with_obstacle_south() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0, -1, Direction.SOUTH));
        //System.out.println("caca" +planetMapImpl.isThereObstacles(Position.of(0, -1, Direction.SOUTH)));
        marsRoverSouth.updateMap(planetMapImpl);
        Position position_rover = marsRoverSouth.move("f");
        assertEquals(position_rover.getX(), 0);
        assertEquals(position_rover.getY(), 0);
        assertEquals(position_rover.getDirection(), Direction.SOUTH);
    }


    @Test
    void move_forward_with_obstacle_east() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(1,0,Direction.EAST));
        marsRoverEast.updateMap(planetMapImpl);
        Position position_rover = marsRoverEast.move("f");
        assertEquals(position_rover.getX(), 0);
        assertEquals(position_rover.getY(), 0);
        assertEquals(position_rover.getDirection(), Direction.EAST);
    }

    @Test
    void move_forward_with_obstacle_west() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(-1,0,Direction.WEST));
        marsRoverWest.updateMap(planetMapImpl);
        Position position_rover = marsRoverWest.move("f");
        assertEquals(position_rover.getX(), 0);
        assertEquals(position_rover.getY(), 0);
        assertEquals(position_rover.getDirection(), Direction.WEST);
    }

    @Test
    void move_backward_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0,-1,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("b");
        assertEquals(position_rover.getX(), 0);
        assertEquals(position_rover.getY(), 0);
        assertEquals(position_rover.getDirection(), Direction.NORTH);
    }


    @Test
    void move_left_with_obstacle() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(-1,0,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("lf");
        assertEquals(position_rover.getX(), 0);
        assertEquals(position_rover.getY(), 0);
        assertEquals(position_rover.getDirection(),Direction.WEST );
    }

    @Test
    void move_right_with_obstacle() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(1,0,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("rf");
        assertEquals(position_rover.getX(), 0);
        assertEquals(position_rover.getY(), 0);
        assertEquals(position_rover.getDirection(),Direction.EAST );
    }

    @Test
    void move_f_f_f_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0,2,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("fff");
        assertEquals(position_rover.getX(), 0);
        assertEquals(1,position_rover.getY());
        assertEquals(position_rover.getDirection(), Direction.NORTH);
    }

    @Test
    void move_f_f_l_b_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0,1,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("fflb");
        assertEquals(position_rover.getX(), 1);
        assertEquals(position_rover.getY(), 0);
        assertEquals(position_rover.getDirection(), Direction.WEST);
    }

    @Test
    void destroy_obstacle_north() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        Position p = Position.of(0,1,Direction.NORTH);
        planetMapImpl.addObstacles(p);
        marsRover.updateMap(planetMapImpl);
        boolean checkObs = planetMapImpl.isThereObstacles(p);
        assertEquals(true, checkObs);
        marsRover.configureLaserRange(2);
        marsRover.destroy();
        marsRover.updateMap(planetMapImpl);
        boolean destroyed = planetMapImpl.isThereObstacles(p);
        assertEquals(false, destroyed);
    }

    @Test
    void destroy_obstacle_south() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        Position p = Position.of(0,-1,Direction.SOUTH);
        planetMapImpl.addObstacles(p);
        marsRover.updateMap(planetMapImpl);
        boolean checkObs = planetMapImpl.isThereObstacles(p);
        assertEquals(true, checkObs);
        marsRover.configureLaserRange(2);
        marsRover.destroy();
        marsRover.updateMap(planetMapImpl);
        boolean destroyed = planetMapImpl.isThereObstacles(p);
        assertEquals(false, destroyed);
    }
    @Test
    void destroy_obstacle_west() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        Position p = Position.of(-1,0,Direction.WEST);
        planetMapImpl.addObstacles(p);
        marsRover.updateMap(planetMapImpl);
        boolean checkObs = planetMapImpl.isThereObstacles(p);
        assertEquals(true, checkObs);
        marsRover.configureLaserRange(2);
        marsRover.destroy();
        marsRover.updateMap(planetMapImpl);
        boolean destroyed = planetMapImpl.isThereObstacles(p);
        assertEquals(false, destroyed);
    }

    @Test
    void destroy_obstacle_east() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        Position p = Position.of(1,0,Direction.EAST);
        planetMapImpl.addObstacles(p);
        marsRover.updateMap(planetMapImpl);
        boolean checkObs = planetMapImpl.isThereObstacles(p);
        assertEquals(true, checkObs);
        marsRover.configureLaserRange(2);
        marsRover.destroy();
        marsRover.updateMap(planetMapImpl);
        boolean destroyed = planetMapImpl.isThereObstacles(p);
        assertEquals(false, destroyed);
    }

    @Test
    void destroy_obstacle_0_2() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        Position p = Position.of(0,2,Direction.NORTH);
        planetMapImpl.addObstacles(p);
        marsRover.updateMap(planetMapImpl);
        marsRover.configureLaserRange(2);
        Position position_rover = marsRover.move("sff");
        marsRover.updateMap(planetMapImpl);
        assertEquals(position_rover.getX(), 0);
        assertEquals(position_rover.getY(), 2);
        assertEquals(position_rover.getDirection(), Direction.NORTH);
    }




}
