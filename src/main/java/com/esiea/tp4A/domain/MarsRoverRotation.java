package com.esiea.tp4A.domain;

public class MarsRoverRotation {
    public Position rotateLeft(Position posRover) {
        switch (posRover.getDirection()) {
            case NORTH:
                return posRover = Position.of(posRover.getX(), posRover.getY(), Direction.WEST);
            case SOUTH:
                return posRover = Position.of(posRover.getX(), posRover.getY(), Direction.EAST);
            case WEST:
                return posRover = Position.of(posRover.getX(), posRover.getY(), Direction.SOUTH);
            case EAST:
                return posRover = Position.of(posRover.getX(), posRover.getY(), Direction.NORTH);
            default:
                return posRover;
        }
    }

    public Position rotateRight(Position posRover) {
        switch (posRover.getDirection()) {
            case NORTH:
                return posRover = Position.of(posRover.getX(), posRover.getY(), Direction.EAST);
            case SOUTH:
                return posRover = Position.of(posRover.getX(), posRover.getY(), Direction.WEST);
            case WEST:
                return posRover = Position.of(posRover.getX(), posRover.getY(), Direction.NORTH);
            case EAST:
                return posRover = Position.of(posRover.getX(), posRover.getY(), Direction.SOUTH);
            default:
                return posRover;
        }
    }
}
