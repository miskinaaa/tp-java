package main.java.com.esiea.tp4A.domain;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class MarsRoverImpl implements MarsRover {

    private Position position;
    private Position nextPos;
    private PlanetMapImpl map;
    private int laserRange;

    public Position getPosition() {
        return position;
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
            } else {
                return this.position;
            }
        }
        return this.position;
    }

    private Position moveForward() {
        switch (this.position.getDirection()) {
            case NORTH:
                this.position = Position.of(this.position.getX(), change_position_plus(this.position.getY()), Direction.NORTH);
                return this.position;
            case SOUTH:
                this.position = Position.of(this.position.getX(), change_position_minus(this.position.getY()), Direction.SOUTH);
                return this.position;
            case WEST:
                this.position = Position.of(change_position_minus(this.position.getX()), this.position.getY(), Direction.WEST);
                return this.position;
            case EAST:
                position = Position.of(change_position_plus(this.position.getX()), this.position.getY(), Direction.EAST);
                return this.position;
            default:
                return this.position;
        }
    }

    private Position moveBackward() {
        switch (this.position.getDirection()) {
            case NORTH:
                this.position = Position.of(this.position.getX(), change_position_minus(this.position.getY()), Direction.NORTH);
                return this.position;
            case SOUTH:
                this.position = Position.of(this.position.getX(), change_position_plus(this.position.getY()), Direction.SOUTH);
                return this.position;
            case WEST:
                this.position = Position.of(change_position_plus(this.position.getX()), this.position.getY(), Direction.WEST);
                return this.position;
            case EAST:
                this.position = Position.of(change_position_minus(this.position.getX()), this.position.getY(), Direction.EAST);
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


    public int change_position_plus(int x) {
        if (x < this.map.getSIZE_OF_MAP() / 2) {
            x++;
        } else if (x >= (this.map.getSIZE_OF_MAP() / 2)) {
            x = (-this.map.getSIZE_OF_MAP() / 2) + 1;
        }
        return x;
    }

    public int change_position_minus(int x) {
        if (x > (-this.map.getSIZE_OF_MAP() / 2)) {
            x--;
        } else if (x == (-this.map.getSIZE_OF_MAP() / 2)) {
            x = (this.map.getSIZE_OF_MAP() / 2) - 1;
        }
        return x;
    }


    private Position newPosition(Position pos, String command, Direction dir) {
        //"TOUT DROIT" : f N ; b S ; r W ; l E
        if ((command.equals("f") && dir.equals(Direction.NORTH)) || (command.equals("b") && dir.equals(Direction.SOUTH)) || (command.equals("r") && dir.equals(Direction.WEST)) || (command.equals("l") && dir.equals(Direction.EAST))) {
            nextPos = Position.of(this.position.getX(), change_position_plus(this.position.getY()), this.position.getDirection());
        }
        //"DERRIERE" : f S ; b N ; r E ; l W
        else if ((command.equals("f") && dir.equals(Direction.SOUTH)) || (command.equals("b") && dir.equals(Direction.NORTH)) || (command.equals("r") && dir.equals(Direction.EAST)) || (command.equals("l") && dir.equals(Direction.WEST))) {
            nextPos = Position.of(this.position.getX(), change_position_minus(this.position.getY()), this.position.getDirection());
        }
        //a droite
        else if ((command.equals("f") && dir.equals(Direction.EAST)) || (command.equals("b") && dir.equals(Direction.WEST))){
            nextPos = Position.of(change_position_plus(this.position.getX()), this.position.getY(), this.position.getDirection());
        }

        else if ((command.equals("f") && dir.equals(Direction.WEST)) || (command.equals("b") && dir.equals(Direction.EAST))){
            nextPos = Position.of(change_position_minus(this.position.getX()), this.position.getY(), this.position.getDirection());
        }
        return nextPos;
    }
}