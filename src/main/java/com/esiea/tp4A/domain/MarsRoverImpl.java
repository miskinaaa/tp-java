package main.java.com.esiea.tp4A.domain;

public class MarsRoverImpl implements MarsRover {

    private Position position;
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
        System.out.println(command);
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'f') {
                if (this.map.isThereObstacles(this.position)) {
                    System.out.println("A: " + this.map.isThereObstacles(this.position));
                    break;
                }
                else {
                    System.out.println("B: " + map.isThereObstacles(position));
                    System.out.println("move forward");
                    moveForward();
                }
            } else if (command.charAt(i) == 'b') {
                //if (this.map != null && this.map.isThereObstacles(this.position)) {
                    moveBackward();
                //}
            } else if (command.charAt(i) == 'l') {
                //if (this.map != null && this.map.isThereObstacles(this.position)) {
                    rotateLeft();
                //}
            } else if (command.charAt(i) == 'r') {
                //if (this.map != null && this.map.isThereObstacles(this.position)) {
                    rotateRight();
                //}
            } else {
                return position;
            }
        }
        return position;
    }

    private Position moveForward() {
        switch (this.position.getDirection()) {
            case NORTH:
                position = Position.of(position.getX(),change_position_plus(position.getY()), Direction.NORTH);
                return position;
            case SOUTH:
                position = Position.of(position.getX(), change_position_minus(position.getY()), Direction.SOUTH);
                return position;
            case WEST:
                position = Position.of(change_position_minus(position.getX()), position.getY(), Direction.WEST);
                return position;
            case EAST:
                position = Position.of(change_position_plus(position.getX()), position.getY(), Direction.EAST);
                return position;
            default:
                return position;
        }
    }

    private Position moveBackward() {
        switch (this.position.getDirection()) {
            case NORTH:
                position = Position.of(position.getX(), change_position_minus(position.getY()), Direction.NORTH);
                return position;
            case SOUTH:
                position = Position.of(position.getX(), change_position_plus(position.getY()), Direction.SOUTH);
                return position;
            case WEST:
                position = Position.of(change_position_plus(position.getX()), position.getY(), Direction.WEST);
                return position;
            case EAST:
                position = Position.of(change_position_minus(position.getX()), position.getY(), Direction.EAST);
                return position;
            default:
                return position;
        }
    }


    private Position rotateLeft() {
        switch (this.position.getDirection()) {
            case NORTH:
                position = Position.of(position.getX(), position.getY(), Direction.WEST);
                return position;
            case SOUTH:
                position = Position.of(position.getX(), position.getY(), Direction.EAST);
                return position;
            case WEST:
                position = Position.of(position.getX(), position.getY(), Direction.SOUTH);
                return position;
            case EAST:
                position = Position.of(position.getX(), position.getY(), Direction.NORTH);
                return position;
            default:
                return position;
        }
    }

    private Position rotateRight() {
        switch (this.position.getDirection()) {
            case NORTH:
                position = Position.of(position.getX(), position.getY(), Direction.EAST);
                return position;
            case SOUTH:
                position = Position.of(position.getX(), position.getY(), Direction.WEST);
                return position;
            case WEST:
                position = Position.of(position.getX(), position.getY(), Direction.NORTH);
                return position;
            case EAST:
                position = Position.of(position.getX(), position.getY(), Direction.SOUTH);
                return position;
            default:
                return position;
        }
    }


    public int change_position_plus(int x) {
        if(x < this.map.getSIZE_OF_MAP() / 2) {
            x++;
        }
        else if(x >= (this.map.getSIZE_OF_MAP() / 2)) {
            x = (-this.map.getSIZE_OF_MAP() / 2) + 1;
        }
        return x;
    }

    public int change_position_minus(int x) {
        if(x > (-this.map.getSIZE_OF_MAP() / 2)) {
            x --;
        }
        else if(x == (-this.map.getSIZE_OF_MAP() / 2)) {
            x = (this.map.getSIZE_OF_MAP() / 2) - 1;
        }
        return x;
    }
}