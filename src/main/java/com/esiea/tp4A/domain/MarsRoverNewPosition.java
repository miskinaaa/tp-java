package com.esiea.tp4A.domain;

public class MarsRoverNewPosition {
    public Position newPosition(Position pos, String command, Direction dir, PlanetMapImpl map, MarsRoverDeplacement marsRoverDeplacement) {
        Position nextPos;
        if ((command.equals("f") && dir.equals(Direction.NORTH)) || (command.equals("b") && dir.equals(Direction.SOUTH)) || (command.equals("r") && dir.equals(Direction.WEST)) || (command.equals("l") && dir.equals(Direction.EAST))) {
            nextPos = Position.of(pos.getX(), marsRoverDeplacement.changePositionPlus(pos.getY(), map), pos.getDirection());
        }
        else if ((command.equals("f") && dir.equals(Direction.SOUTH)) || (command.equals("b") && dir.equals(Direction.NORTH)) || (command.equals("r") && dir.equals(Direction.EAST)) || (command.equals("l") && dir.equals(Direction.WEST))) {
            nextPos = Position.of(pos.getX(), marsRoverDeplacement.changePositionMinus(pos.getY(),map), pos.getDirection());
        }
        else if ((command.equals("f") && dir.equals(Direction.EAST)) || (command.equals("b") && dir.equals(Direction.WEST))) {
            nextPos = Position.of(marsRoverDeplacement.changePositionPlus(pos.getX(),map), pos.getY(), pos.getDirection());
        }
        else {
            nextPos = Position.of(marsRoverDeplacement.changePositionMinus(pos.getX(),map), pos.getY(), pos.getDirection());
        }
        return nextPos;
    }
}
