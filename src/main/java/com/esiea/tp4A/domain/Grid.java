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
}
