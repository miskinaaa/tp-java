package main.java.com.esiea.tp4A.domain;

import java.util.List;

public class Grid {
    private int x;
    private int y;
    private MarsRoverImpl marsRover;


    public Grid(int x, int y, MarsRoverImpl marsRover) {
        this.x = x;
        this.y = y;
        this.marsRover = marsRover;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void newCordo(int x, int y) {
        setX(x);
        setY(y);
        //moving north when (0,50,N)
        if(marsRover.getY() == 50 && marsRover.getDirection() == Direction.NORTH) {
            setY(-49);
        }
        //moving east when (50,0,E)
        else if(marsRover.getX() == 50 && marsRover.getDirection() == Direction.EAST) {
            setX(-49);
        }
        //moving south when (0,-50,S)
        else if(marsRover.getY() == -50 && marsRover.getDirection() == Direction.SOUTH) {
            setY(49);
        }
        //moving west when (-50,0,W)
        else if(marsRover.getX() == -50 && marsRover.getDirection() == Direction.WEST) {
            setX(49);
        }

    }
}
