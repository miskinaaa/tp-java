package main.java.com.esiea.tp4A.domain;

public class MarsRoverImpl implements MarsRover {

    private int x;
    private int y;
    private Direction direction;
    private PlanetMapImpl map;

    public MarsRoverImpl() {  }

    @Override
    public MarsRover initialize(Position pos) {
        this.x = pos.getX();
        this.y = pos.getY();
        this.direction = pos.getDirection();
        return this;
    }

    @Override
    public MarsRover updateMap(PlanetMap map) {
        this.map = (PlanetMapImpl) map;
        return this;
    }

    @Override
    public MarsRover configureLaserRange(int range) {
        return null;
    }

    @Override
    public Position move(String command) {
        switch (command) {
            case "f":
                if (direction == Direction.NORTH)
                    this.y += 1;
                if (direction == Direction.SOUTH)
                    this.y -= 1;
                if (direction == Direction.WEST)
                    this.x -= 1;
                if (direction == Direction.EAST)
                    this.x += 1;
                break;
            case "b":
                if (direction == Direction.NORTH)
                    this.y -= 1;
                if (direction == Direction.SOUTH)
                    this.y += 1;
                if (direction == Direction.WEST)
                    this.x += 1;
                if (direction == Direction.EAST)
                    this.x -= 1;
                break;
            case "l":
                if (direction == Direction.NORTH)
                    this.direction = Direction.WEST;
                else if (direction == Direction.SOUTH)
                    this.direction = Direction.EAST;
                else if (direction == Direction.WEST)
                    this.direction = Direction.SOUTH;
                else
                    this.direction = Direction.NORTH;
                break;
            case "r":
                if (direction == Direction.NORTH)
                    this.direction = Direction.EAST;
                else if (direction == Direction.SOUTH)
                    this.direction = Direction.WEST;
                else if (direction == Direction.WEST)
                    this.direction = Direction.NORTH;
                else
                    this.direction = Direction.SOUTH;
                break;
            default:
                return null;
        }
        return Position.of(x,y,direction);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
