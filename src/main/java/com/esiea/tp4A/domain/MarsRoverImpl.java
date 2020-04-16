package com.esiea.tp4A.domain;

public class MarsRoverImpl implements MarsRover {
    private Position position;
    private PlanetMapImpl map;
    private int laserRange;
    private String playerName;
    private MarsRoverNewPosition marsRoverNewPosition;
    private MarsRoverMove marsRoverMove;
    private boolean isPlayerAlive;

    public boolean isPlayerAlive() {
        return isPlayerAlive;
    }

    public Position getPosition() {
        return position;
    }
    public int getLaserRange() {
        return laserRange;
    }

    public MarsRoverImpl(Position position, PlanetMapImpl map ) {
        this.initialize(position);
        this.map = map;
        configureLaserRange(5);
        isPlayerAlive = true;
    }

    public MarsRover initialize(Position position) {
        this.position = position;
        this.map = (PlanetMapImpl) new PlanetMapImpl().initialize();
        this.marsRoverNewPosition = new MarsRoverNewPosition();
        this.marsRoverMove = new MarsRoverMove();
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
        this.position = marsRoverMove.move(command, this.position, marsRoverNewPosition, map, getLaserRange());
        return this.position;
    }
}
