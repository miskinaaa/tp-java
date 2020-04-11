package api.java.com.esiea.tp4A.domain;

import main.java.com.esiea.tp4A.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public interface Api {

    Api initialize(Game game, String playerName);

    //Connaitre leur position
    Position getPosition(String playerName);

    //connaitre la position des obstacles et joueurs adverses dans un carré de 30x30 (par défaut) autour du joueur (radar)
    Set<Position> getObstaclesPlayers(String playerName);

    //connaitre la portée du laser
    int getLaserRange(String playerName);

    //se déplacer
    Position movePlayer(String playerName , String command);

    //tirer avec le laser
    void laserShoot(String playerName);

    //savoir le statut de son personnage (mort ou vivant)
    boolean isPlayerAlive(String playerName);

}
