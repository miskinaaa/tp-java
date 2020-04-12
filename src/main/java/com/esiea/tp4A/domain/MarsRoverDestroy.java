package com.esiea.tp4A.domain;

public class MarsRoverDestroy {

    public Position destroy(Position position, int laserRanger , PlanetMapImpl map) {
        switch (position.getDirection()) {
            case NORTH:
                for (int i = 0; i <= laserRanger; i++) {
                    Position positionShoot = Position.of(position.getX(), position.getY() + i, Direction.NORTH);
                    if (map.isThereObstacles(positionShoot)) {
                        map.removeObstacles(positionShoot);
                        break;
                    }
                }
            case SOUTH:
                for (int i = 0; i <= laserRanger; i++) {
                    Position positionShoot = Position.of(position.getX(), position.getY() - i, Direction.SOUTH);
                    if (map.isThereObstacles(positionShoot)) {
                        map.removeObstacles(positionShoot);
                        break;
                    }
                }
            case WEST:
                for (int i = 0; i <= laserRanger; i++) {
                    Position positionShoot = Position.of(position.getX() - i, position.getY(), Direction.WEST);
                    if (map.isThereObstacles(positionShoot)) {
                        map.removeObstacles(positionShoot);
                        break;
                    }
                }
            case EAST:
                for (int i = 0; i <= laserRanger; i++) {
                    Position positionShoot = Position.of(position.getX() + i, position.getY(), Direction.EAST);
                    if (map.isThereObstacles(positionShoot)) {
                        map.removeObstacles(positionShoot);
                        break;
                    }
                }
        }
        return position;
    }
}
