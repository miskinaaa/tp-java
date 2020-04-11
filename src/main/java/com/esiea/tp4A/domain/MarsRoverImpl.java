package com.esiea.tp4A.domain;

import com.esiea.tp4A.domain.*;

public class MarsRoverImpl implements MarsRover {

    private Position position;
    private Position nextPos;
    private PlanetMapImpl map;
    private int laserRange;
    private String playerName;

    public Position getPosition() {
        return position;
    }

    public int getLaserRange() {
        return laserRange;
    }

    public String getPlayerName() {
        return playerName;
    }

    public MarsRoverImpl(Position position, PlanetMapImpl map, String playerName ) {
        this.playerName = playerName;
        this.initialize(position);
        this.map = map;
    }

    public MarsRover initialize(Position position) {
        this.position = position;
        this.map = (PlanetMapImpl) new PlanetMapImpl().initialize();
        return this;
    }


    @Override
    public MarsRover updateMap(PlanetMap map) {
        this.map = (PlanetMapImpl) map;
        return this;
    }

    @Override
    public MarsRover configureLaserRange(int range) {
        this.laserRange = range;
        return this;
    }

    @Override
    public Position move(String command) {
        command = command.toLowerCase();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'f') {
                nextPos = newPosition(this.position, String.valueOf(command.charAt(i)), this.position.getDirection());
                if (this.map.isThereObstacles(nextPos)) {
                    continue;
                } else {
                    moveForward();
                }
            } else if (command.charAt(i) == 'b') {
                nextPos = newPosition(this.position, String.valueOf(command.charAt(i)), this.position.getDirection());
                if (this.map.isThereObstacles(nextPos)) {
                    continue;
                } else {
                    moveBackward();
                }
            } else if (command.charAt(i) == 'l') {
                rotateLeft();
            } else if (command.charAt(i) == 'r') {
                rotateRight();
            } else if (command.charAt(i) == 's') {
                destroy();
            } else {
                return this.position;
            }
        }
        return this.position;
    }

    private Position moveForward() {
        switch (this.position.getDirection()) {
            case NORTH:
                this.position = Position.of(this.position.getX(), changePositionPlus(this.position.getY()), Direction.NORTH);
                return this.position;
            case SOUTH:
                this.position = Position.of(this.position.getX(), changePositionMinus(this.position.getY()), Direction.SOUTH);
                return this.position;
            case WEST:
                this.position = Position.of(changePositionMinus(this.position.getX()), this.position.getY(), Direction.WEST);
                return this.position;
            case EAST:
                position = Position.of(changePositionPlus(this.position.getX()), this.position.getY(), Direction.EAST);
                return this.position;
            default:
                return this.position;
        }
    }

    private Position moveBackward() {
        switch (this.position.getDirection()) {
            case NORTH:
                this.position = Position.of(this.position.getX(), changePositionMinus(this.position.getY()), Direction.NORTH);
                return this.position;
            case SOUTH:
                this.position = Position.of(this.position.getX(), changePositionPlus(this.position.getY()), Direction.SOUTH);
                return this.position;
            case WEST:
                this.position = Position.of(changePositionPlus(this.position.getX()), this.position.getY(), Direction.WEST);
                return this.position;
            case EAST:
                this.position = Position.of(changePositionMinus(this.position.getX()), this.position.getY(), Direction.EAST);
                return this.position;
            default:
                return this.position;
        }
    }


    private Position rotateLeft() {
        switch (this.position.getDirection()) {
            case NORTH:
                this.position = Position.of(this.position.getX(), this.position.getY(), Direction.WEST);
                return this.position;
            case SOUTH:
                this.position = Position.of(this.position.getX(), this.position.getY(), Direction.EAST);
                return this.position;
            case WEST:
                this.position = Position.of(this.position.getX(), this.position.getY(), Direction.SOUTH);
                return this.position;
            case EAST:
                this.position = Position.of(this.position.getX(), this.position.getY(), Direction.NORTH);
                return this.position;
            default:
                return this.position;
        }
    }

    private Position rotateRight() {
        switch (this.position.getDirection()) {
            case NORTH:
                position = Position.of(this.position.getX(), this.position.getY(), Direction.EAST);
                return this.position;
            case SOUTH:
                position = Position.of(this.position.getX(), this.position.getY(), Direction.WEST);
                return this.position;
            case WEST:
                position = Position.of(this.position.getX(), this.position.getY(), Direction.NORTH);
                return this.position;
            case EAST:
                position = Position.of(this.position.getX(), this.position.getY(), Direction.SOUTH);
                return this.position;
            default:
                return this.position;
        }
    }


    public int changePositionPlus(int x) {
        if (x < this.map.getSIZE_OF_MAP() / 2) {
            x++;
        } else if (x >= (this.map.getSIZE_OF_MAP() / 2)) {
            x = (-this.map.getSIZE_OF_MAP() / 2) + 1;
        }
        return x;
    }

    public int changePositionMinus(int x) {
        if (x > (-this.map.getSIZE_OF_MAP() / 2)) {
            x--;
        } else if (x == (-this.map.getSIZE_OF_MAP() / 2)) {
            x = (this.map.getSIZE_OF_MAP() / 2) - 1;
        }
        return x;
    }


    private Position newPosition(Position pos, String command, Direction dir) {
        if ((command.equals("f") && dir.equals(Direction.NORTH)) || (command.equals("b") && dir.equals(Direction.SOUTH)) || (command.equals("r") && dir.equals(Direction.WEST)) || (command.equals("l") && dir.equals(Direction.EAST))) {
            nextPos = Position.of(this.position.getX(), changePositionPlus(this.position.getY()), this.position.getDirection());
        }
        else if ((command.equals("f") && dir.equals(Direction.SOUTH)) || (command.equals("b") && dir.equals(Direction.NORTH)) || (command.equals("r") && dir.equals(Direction.EAST)) || (command.equals("l") && dir.equals(Direction.WEST))) {
            nextPos = Position.of(this.position.getX(), changePositionMinus(this.position.getY()), this.position.getDirection());
        }
        else if ((command.equals("f") && dir.equals(Direction.EAST)) || (command.equals("b") && dir.equals(Direction.WEST))) {
            nextPos = Position.of(changePositionPlus(this.position.getX()), this.position.getY(), this.position.getDirection());
        } else if ((command.equals("f") && dir.equals(Direction.WEST)) || (command.equals("b") && dir.equals(Direction.EAST))) {
            nextPos = Position.of(changePositionMinus(this.position.getX()), this.position.getY(), this.position.getDirection());
        }
        return nextPos;
    }

    public Position destroy() {
        switch (this.position.getDirection()) {
            case NORTH:
                for (int i = 0; i <= this.getLaserRange(); i++) {
                    Position positionShoot = Position.of(position.getX(), position.getY() + i, Direction.NORTH);
                    if (map.isThereObstacles(positionShoot)) {
                        map.removeObstacles(positionShoot);
                        break;
                    }
                }
            case SOUTH:
                for (int i = 0; i <= this.getLaserRange(); i++) {
                    Position positionShoot = Position.of(position.getX(), position.getY() - i, Direction.SOUTH);
                    if (map.isThereObstacles(positionShoot)) {
                        map.removeObstacles(positionShoot);
                        break;
                    }
                }
            case WEST:
                for (int i = 0; i <= this.getLaserRange(); i++) {
                    Position positionShoot = Position.of(position.getX() - i, position.getY(), Direction.WEST);
                    if (map.isThereObstacles(positionShoot)) {
                        map.removeObstacles(positionShoot);
                        break;
                    }
                }
            case EAST:
                for (int i = 0; i <= this.getLaserRange(); i++) {
                    Position positionShoot = Position.of(position.getX() + i, position.getY(), Direction.EAST);
                    if (map.isThereObstacles(positionShoot)) {
                        map.removeObstacles(positionShoot);
                        break;
                    }
                }
        }
        return this.position;
    }

}
