package api.java.com.esiea.tp4A.domain;

import main.java.com.esiea.tp4A.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface Api {
    //Connaitre leur position
    Position getPosition(String player);

    //connaitre la position des obstacles et joueurs adverses dans un carré de 30x30 (par défaut) autour du joueur (radar)
    MarsRover getObstaclesPlayers(String player);

    //connaitre la portée du laser
    int getLaserRange();

    //se déplacer
    Position movePlayer(String player , String command);

    //tirer avec le laser
    void laserShoot(String player);

    //savoir le statut de son personnage (mort ou vivant)
    boolean isPlayerAlive(String player);

}
