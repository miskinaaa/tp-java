package com.esiea.tp4A.domain;

public class MarsRoverDeplacement {
    public Position moveForward(Position posRover, PlanetMapImpl map) {
        switch (posRover.getDirection()) {
            case NORTH:
                return posRover = Position.of(posRover.getX(), changePositionPlus(posRover.getY(), map), Direction.NORTH);
            case SOUTH:
                return posRover = Position.of(posRover.getX(), changePositionMinus(posRover.getY(), map), Direction.SOUTH);
            case WEST:
                return posRover = Position.of(changePositionMinus(posRover.getX(), map), posRover.getY(), Direction.WEST);
            case EAST:
                return posRover = Position.of(changePositionPlus(posRover.getX(), map), posRover.getY(), Direction.EAST);
            default:
                return posRover;
        }
    }

    public Position moveBackward(Position posRover, PlanetMapImpl map) {
        switch (posRover.getDirection()) {
            case NORTH:
                return posRover = Position.of(posRover.getX(), changePositionMinus(posRover.getY(), map), Direction.NORTH);
            case SOUTH:
                return posRover = Position.of(posRover.getX(), changePositionPlus(posRover.getY(), map), Direction.SOUTH);
            case WEST:
                return posRover = Position.of(changePositionPlus(posRover.getX(), map), posRover.getY(), Direction.WEST);
            case EAST:
                return posRover = Position.of(changePositionMinus(posRover.getX(), map), posRover.getY(), Direction.EAST);
            default:
                return posRover;
        }
    }


    public int changePositionPlus(int x, PlanetMapImpl map) {
        if (x < map.getSIZE_OF_MAP() / 2) {
            x++;
        } else if (x >= (map.getSIZE_OF_MAP() / 2)) {
            x = (-map.getSIZE_OF_MAP() / 2) + 1;
        } else if (x == (map.getSIZE_OF_MAP() / 2)) {
            x = ((map.getSIZE_OF_MAP() / 2) - 1);;
        }
        return x;
    }

    public int changePositionMinus(int x, PlanetMapImpl map) {
        if (x > (-map.getSIZE_OF_MAP() / 2)) {
            x--;
        } else if (x == (-map.getSIZE_OF_MAP() / 2)) {
            x = (map.getSIZE_OF_MAP() / 2) - 1;
        }
        else if (x == -((map.getSIZE_OF_MAP() / 2) - 1)) {
            return map.getSIZE_OF_MAP() / 2;
        }
        return x;
    }
}
