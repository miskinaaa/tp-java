package com.esiea.tp4A.domain;

public class MarsRoverDestroy {

    public Position destroy(Position position, int laserRanger, PlanetMapImpl map) {
        for (int i = 0; i <= laserRanger; i++) {
            Position positionShoot = checkObstaclePosition(position, i);
            if (breakObstacle(map, positionShoot)) break;
        }
        return position;
    }

    private Position checkObstaclePosition(Position position, int cpt) {
        Position positionShoot = null;
        switch (position.getDirection()) {
            case NORTH:
                positionShoot = Position.of(position.getX(), position.getY() + cpt, Direction.NORTH);
                break;
            case SOUTH:
                positionShoot = Position.of(position.getX(), position.getY() - cpt, Direction.SOUTH);
                break;
            case WEST:
                positionShoot = Position.of(position.getX() - cpt, position.getY(), Direction.WEST);
                break;
            case EAST:
                positionShoot = Position.of(position.getX() + cpt, position.getY(), Direction.EAST);
                break;
        }
        return positionShoot;
    }

    private boolean breakObstacle(PlanetMapImpl map, Position positionShoot) {
        if (map.isThereObstacles(positionShoot)) {
            map.removeObstacles(positionShoot);
            return true;
        }
        return false;
    }
}
