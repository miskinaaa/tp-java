package main.java.com.esiea.tp4A.domain;

import java.util.HashSet;
import java.util.Set;

public class PlanetMapImpl implements PlanetMap {
    private Set<Position> obstaclePositions;
    private int SIZE_OF_MAP = 100;

    public PlanetMap initialize() {
        initialize(new HashSet<>());
        return this;
    }

    public PlanetMap initialize(int size) {
        this.SIZE_OF_MAP = size;
        initialize(new HashSet<>());
        return this;
    }


    public PlanetMap initialize(Set<Position> positions) {
        this.obstaclePositions = positions;
        return this;
    }

    @Override
    public Set<Position> obstaclePositions() {
        return this.obstaclePositions;
    }

    public int getSIZE_OF_MAP() {
        return SIZE_OF_MAP;
    }

    public int setSIZE_OF_MAP(int SIZE_OF_MAP) {
        this.SIZE_OF_MAP = SIZE_OF_MAP;
        return SIZE_OF_MAP;
    }

    public boolean addObstacles(Position position) {
        if (!this.isThereObstacles(position)) {
            this.obstaclePositions.add(position);
            return true;
        }
        return false;
    }

    public void removeObstacles(Position position) {
        this.obstaclePositions.removeIf(obstaclePosition -> obstaclePosition.getX() == position.getX() && obstaclePosition.getY() == position.getY());
    }


    public boolean isThereObstacles(Position position) {
        for (Position p : obstaclePositions) {
            if (p.getX() == position.getX() && p.getY() == position.getY()) {
                return true;
            }
        }
        return false;
    }

    public Set<Position> getObstaclePositions() {
        return obstaclePositions;
    }
}