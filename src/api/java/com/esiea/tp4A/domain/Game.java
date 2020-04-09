package api.java.com.esiea.tp4A.domain;

import main.java.com.esiea.tp4A.domain.Direction;
import main.java.com.esiea.tp4A.domain.MarsRoverImpl;
import main.java.com.esiea.tp4A.domain.PlanetMapImpl;
import main.java.com.esiea.tp4A.domain.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    PlanetMapImpl planetMapImpl = new PlanetMapImpl();
    MarsRoverImpl marsRoverImpl = (MarsRoverImpl) new MarsRoverImpl();
    List<MarsRoverImpl> listPlayers =  new ArrayList<MarsRoverImpl>();


    // Taille de la carte
    public int randomMapSize(){
        int[] map_size_array = {100,300,600};
        int index = new Random().nextInt(map_size_array.length);
        int map_size = planetMapImpl.setSIZE_OF_MAP(map_size_array[index]);
        return map_size ;
    }

    // Direction aléatoire
    public Direction randomDirection(){
        Direction tabDirection[] = {Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH};
        int index = new Random().nextInt(tabDirection.length);
        Direction direction = tabDirection[index];
        return direction;
    }

    //Position aléatoire
    public Position randomPosition(){
        Random rand = new Random();
        int positiveNb = rand.nextInt(planetMapImpl.getSIZE_OF_MAP() / 2 );
        int negativeNb = rand.nextInt(-planetMapImpl.getSIZE_OF_MAP() / 2);
        int x = (int)(Math.random() * ((positiveNb - negativeNb) + 1)) + negativeNb;
        int y = (int)(Math.random() * ((positiveNb - negativeNb) + 1)) + negativeNb;
        Direction direction = randomDirection();
        Position pos = Position.of(x,y, direction);
        return pos;
    }

    // Génère aléatoirement des obstacles
    public void generateObstacles(){
        for(int i = 0; i < planetMapImpl.getSIZE_OF_MAP()*0.15; i++) {
            planetMapImpl.addObstacles(randomPosition());
        }
    }


    //Gènère 50 joueurs
    public List<MarsRoverImpl> randomPlayers(){
        Position position = null;
        for(int i = 1; i<=50; i++) {
            position = randomPosition();
            marsRoverImpl.initialize(position);
            //AFFECTER UN NUMERO AU ROVER
            marsRoverImpl.updateMap(planetMapImpl);
            marsRoverImpl.configureLaserRange(randomLaser());
            listPlayers.add(marsRoverImpl);
        }
        return listPlayers;
    }

    //Portee du laser
    public int randomLaser(){
        int[] laser_array = {5,30};
        int index = new Random().nextInt(laser_array.length);
        return laser_array[index];
    }
}
