package com.esiea.tp4A.domain;
public class MarsRoverMove {

    private final MarsRoverDeplacement marsRoverDeplacement;
    private final MarsRoverRotation marsRoverRotation;
    private final MarsRoverDestroy marsRoverDestroy;

    public MarsRoverMove() {
        this.marsRoverDeplacement = new MarsRoverDeplacement();
        this.marsRoverRotation = new MarsRoverRotation();
        this.marsRoverDestroy = new MarsRoverDestroy();
    }

    public Position move(String command, Position position, MarsRoverNewPosition marsRoverNewPosition, PlanetMapImpl map, int laserRanger) {
        Position nextPos;
        command = command.toLowerCase();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'f') {
                nextPos = marsRoverNewPosition.newPosition(position, String.valueOf(command.charAt(i)), position.getDirection(), map, this.marsRoverDeplacement);
                if (map.isThereObstacles(nextPos)) {
                    continue;
                } else {
                    position = this.marsRoverDeplacement.moveForward(position,map);
                }
            } else if (command.charAt(i) == 'b') {
                nextPos = marsRoverNewPosition.newPosition(position, String.valueOf(command.charAt(i)), position.getDirection(),map, this.marsRoverDeplacement);
                if (map.isThereObstacles(nextPos)) {
                    continue;
                } else {
                    position = this.marsRoverDeplacement.moveBackward(position,map);
                }
            } else if (command.charAt(i) == 'l') {
                position = this.marsRoverRotation.rotateLeft(position);
            } else if (command.charAt(i) == 'r') {
                position = this.marsRoverRotation.rotateRight(position);
            } else if (command.charAt(i) == 's') {
                position = this.marsRoverDestroy.destroy(position, laserRanger , map);
            } else {
                position = position;
            }
        }
        return position;
    }
}
