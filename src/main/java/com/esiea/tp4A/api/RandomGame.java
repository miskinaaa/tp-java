package com.esiea.tp4A.api;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.MarsRoverImpl;
import com.esiea.tp4A.domain.PlanetMapImpl;
import com.esiea.tp4A.domain.Position;

import java.util.*;

public class RandomGame {
    private final PlanetMapImpl planetMapImpl = new PlanetMapImpl();
    private final MarsRoverImpl marsRoverImpl = new MarsRoverImpl((Position.of(0, 50, Direction.NORTH)), planetMapImpl);
    private final Set<Position> obstaclePositions = new HashSet<>();
    private final List<MarsRoverImpl> listPlayers =  new ArrayList<MarsRoverImpl>();
    private final Random rand = new Random();

    public int randomMapSize(){
        int[] map_size_array = {100,300,600};
        int index = new Random().nextInt(map_size_array.length);
        int map_size = planetMapImpl.setSIZE_OF_MAP(map_size_array[index]);
        return map_size ;
    }

    public Direction randomDirection(){
        Direction tabDirection[] = {Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH};
        int index = new Random().nextInt(tabDirection.length);
        Direction direction = tabDirection[index];
        return direction;
    }

    public Position randomPosition(){
        int max = planetMapImpl.getSIZE_OF_MAP() / 2;
        int min = - planetMapImpl.getSIZE_OF_MAP() / 2;
        int x = rand.nextInt((max - min) + 1) + min;
        int y = rand.nextInt((max - min) + 1) + min;
        Direction direction = randomDirection();
        Position pos = Position.of(x,y, direction);
        return pos;
    }

    public Set<Position> generateObstacles(){
        for(int i = 1; i <= planetMapImpl.getSIZE_OF_MAP()*0.15; i++) {
            this.obstaclePositions.add(randomPosition());
        }
        return obstaclePositions;
    }

    public List<MarsRoverImpl> randomPlayers(){
        Position position = null;
        for(int i = 1; i<=50; i++) {
            position = randomPosition();
            marsRoverImpl.initialize(position);
            marsRoverImpl.updateMap(planetMapImpl);
            marsRoverImpl.configureLaserRange(randomLaser());
            listPlayers.add(marsRoverImpl);
        }
        return listPlayers;
    }

    public int randomLaser(){
        int[] laser_array = {5,30,1000};
        int index = new Random().nextInt(laser_array.length);
        return laser_array[index];
    }
}
