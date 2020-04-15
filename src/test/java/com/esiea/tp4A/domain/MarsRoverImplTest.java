package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class MarsRoverImplTest {
    private final PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize(100);
    final MarsRoverImpl  marsRover = new MarsRoverImpl((Position.of(0, 0, Direction.NORTH)), planetMap);
    final MarsRoverImpl  marsRoverSouth = new MarsRoverImpl((Position.of(0, 0, Direction.SOUTH)), planetMap);
    final MarsRoverImpl  marsRoverEast = new MarsRoverImpl((Position.of(0, 0, Direction.EAST)), planetMap);
    final MarsRoverImpl  marsRoverWest = new MarsRoverImpl((Position.of(0, 0, Direction.WEST)), planetMap);


    @Test
    public void isAlive() {
        assertEquals(true,((MarsRoverImpl) marsRover).isPlayerAlive());
    }

    @Test
    public void move_error() {
        Position position_error = marsRover.move("");
        assertEquals(0,position_error.getX());
        assertEquals(0,position_error.getY());
        assertEquals(Direction.NORTH, position_error.getDirection());
    }

    @Test
    public void move_wrong_command() {
        Position position_error = marsRover.move("z");
        assertEquals(0,position_error.getX());
        assertEquals(0,position_error.getY());
        assertEquals(Direction.NORTH, position_error.getDirection());
    }

    @Test
    public void move_backward_east() {
        Position position_south = marsRoverEast.move("b");
        assertEquals(-1,position_south.getX());
        assertEquals( 0, position_south.getY());
        assertEquals( Direction.EAST, position_south.getDirection());
    }

    @Test
    public void move_left() {
        Position position_west = marsRover.move("l");
        assertEquals( 0, position_west.getX());
        assertEquals(0, position_west.getY());
        assertEquals(Direction.WEST, position_west.getDirection());
    }

    @Test
    public void move_right() {
        Position position_east = marsRover.move("r");
        assertEquals(0,position_east.getX());
        assertEquals(0,position_east.getY());
        assertEquals( Direction.EAST, position_east.getDirection());
    }

    @Test
    public void move_right_forward() {
        Position position_east_forward = marsRover.move("rf");
        assertEquals(1,position_east_forward.getX());
        assertEquals(0,position_east_forward.getY());
        assertEquals(Direction.EAST,position_east_forward.getDirection());
    }

    @Test
    public void move_left_forward() {
        Position position_west_forward = marsRover.move("lf");
        assertEquals(-1,position_west_forward.getX());
        assertEquals(0, position_west_forward.getY());
        assertEquals(Direction.WEST, position_west_forward.getDirection());
    }

    @Test
    public void move_to_1_2_w() {
        Position position_west_forward = marsRover.move("fflb");
        assertEquals(1,position_west_forward.getX());
        assertEquals(2,position_west_forward.getY());
        assertEquals( Direction.WEST,position_west_forward.getDirection());
    }

    @Test
    public void move_forward_with_obstacle_north() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0, 1, Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("f");
        assertEquals( 0, position_rover.getX());
        assertEquals(0,position_rover.getY());
        assertEquals(Direction.NORTH, position_rover.getDirection()) ;

    }

    @Test
    public void move_forward_with_obstacle_south() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0, -1, Direction.SOUTH));
        marsRoverSouth.updateMap(planetMapImpl);
        Position position_rover = marsRoverSouth.move("f");
        assertEquals( 0, position_rover.getX());
        assertEquals(0,position_rover.getY());
        assertEquals(Direction.SOUTH, position_rover.getDirection()) ;
    }


    @Test
    public void move_forward_with_obstacle_east() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(1,0,Direction.EAST));
        marsRoverEast.updateMap(planetMapImpl);
        Position position_rover = marsRoverEast.move("f");
        assertEquals( 0, position_rover.getX());
        assertEquals(0,position_rover.getY());
        assertEquals(Direction.EAST, position_rover.getDirection()) ;
    }

    @Test
    public void move_forward_with_obstacle_west() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(-1,0,Direction.WEST));
        marsRoverWest.updateMap(planetMapImpl);
        Position position_rover = marsRoverWest.move("f");
        assertEquals( 0, position_rover.getX());
        assertEquals(0,position_rover.getY());
        assertEquals(Direction.WEST, position_rover.getDirection()) ;
    }

    @Test
    public void move_backward_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0,-1,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("b");
        assertEquals( 0, position_rover.getX());
        assertEquals(0,position_rover.getY());
        assertEquals(Direction.NORTH, position_rover.getDirection()) ;
    }


    @Test
    public void move_left_with_obstacle() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(-1,0,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("lf");
        assertEquals( 0, position_rover.getX());
        assertEquals(0,position_rover.getY());
        assertEquals(Direction.WEST, position_rover.getDirection()) ;
    }

    @Test
    public void move_right_with_obstacle() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(1,0,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("rf");
        assertEquals( 0, position_rover.getX());
        assertEquals(0,position_rover.getY());
        assertEquals(Direction.EAST, position_rover.getDirection()) ;
    }

    @Test
    public void move_f_f_f_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0,2,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("fff");
        assertEquals(0,position_rover.getX());
        assertEquals(1,position_rover.getY());
        assertEquals(Direction.NORTH, position_rover.getDirection()) ;
    }

    @Test
    public void move_f_f_l_b_obstacles() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        planetMapImpl.addObstacles(Position.of(0,1,Direction.NORTH));
        marsRover.updateMap(planetMapImpl);
        Position position_rover = marsRover.move("fflb");
        assertEquals(1,position_rover.getX());
        assertEquals(0,position_rover.getY());
        assertEquals(Direction.WEST, position_rover.getDirection()) ;
    }

    @Test
    public void destroy_obstacle_north() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        MarsRoverDestroy mrd = new MarsRoverDestroy();
        Position p = Position.of(0,1,Direction.NORTH);
        planetMapImpl.addObstacles(p);
        marsRover.updateMap(planetMapImpl);
        boolean checkObs = planetMapImpl.isThereObstacles(p);
        assertEquals(true, checkObs);
        marsRover.configureLaserRange(2);
        mrd.destroy(p, marsRover.getLaserRange() , planetMapImpl);
        marsRover.updateMap(planetMapImpl);
        boolean destroyed = planetMapImpl.isThereObstacles(p);
        assertEquals(false, destroyed);
    }

    @Test
    public void destroy_obstacle_south() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        MarsRoverDestroy mrd = new MarsRoverDestroy();
        Position p = Position.of(0,-1,Direction.SOUTH);
        planetMapImpl.addObstacles(p);
        marsRover.updateMap(planetMapImpl);
        boolean checkObs = planetMapImpl.isThereObstacles(p);
        assertEquals(true, checkObs);
        marsRover.configureLaserRange(2);
        mrd.destroy(p, marsRover.getLaserRange() , planetMapImpl);
        marsRover.updateMap(planetMapImpl);
        boolean destroyed = planetMapImpl.isThereObstacles(p);
        assertEquals(false, destroyed);
    }
    @Test
    public void destroy_obstacle_west() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        MarsRoverDestroy mrd = new MarsRoverDestroy();
        Position p = Position.of(-1,0,Direction.WEST);
        planetMapImpl.addObstacles(p);
        marsRover.updateMap(planetMapImpl);
        boolean checkObs = planetMapImpl.isThereObstacles(p);
        assertEquals(true, checkObs);
        marsRover.configureLaserRange(2);
        mrd.destroy(p, marsRover.getLaserRange() , planetMapImpl);
        marsRover.updateMap(planetMapImpl);
        boolean destroyed = planetMapImpl.isThereObstacles(p);
        assertEquals(false, destroyed);
    }

    @Test
    public void destroy_obstacle_east() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        MarsRoverDestroy mrd = new MarsRoverDestroy();
        Position p = Position.of(1,0,Direction.EAST);
        planetMapImpl.addObstacles(p);
        marsRover.updateMap(planetMapImpl);
        boolean checkObs = planetMapImpl.isThereObstacles(p);
        assertEquals(true, checkObs);
        marsRover.configureLaserRange(2);
        mrd.destroy(p, marsRover.getLaserRange() , planetMapImpl);
        marsRover.updateMap(planetMapImpl);
        boolean destroyed = planetMapImpl.isThereObstacles(p);
        assertEquals(false, destroyed);
    }

    @Test
    public void destroy_obstacle_in_front() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        Position p = Position.of(0,1,Direction.NORTH);
        planetMapImpl.addObstacles(p);
        marsRover.updateMap(planetMapImpl);
        marsRover.configureLaserRange(2);
        Position position_rover = marsRover.move("s");
        marsRover.updateMap(planetMapImpl);
        assertEquals(0,position_rover.getX());
        assertEquals(0,position_rover.getY());
        assertEquals(Direction.NORTH, position_rover.getDirection());
        boolean destroyed = planetMapImpl.isThereObstacles(p);
        assertEquals(false, destroyed);
    }

    @Test
    public void destroy_obstacle_0_2() {
        PlanetMapImpl planetMapImpl = (PlanetMapImpl) new PlanetMapImpl().initialize();
        Position p = Position.of(0,2,Direction.NORTH);
        planetMapImpl.addObstacles(p);
        marsRover.updateMap(planetMapImpl);
        marsRover.configureLaserRange(2);
        Position position_rover = marsRover.move("sff");
        marsRover.updateMap(planetMapImpl);
        assertEquals(0,position_rover.getX());
        assertEquals(2,position_rover.getY());
        assertEquals(Direction.NORTH, position_rover.getDirection());
    }

}
