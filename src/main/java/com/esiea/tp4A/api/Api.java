package com.esiea.tp4A.api;

import com.esiea.tp4A.domain.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class Api {

    private final Map<Integer, MarsRoverImpl> players = new HashMap<>();
    private final Integer idPlayer = (1 + (int)(Math.random() * ((50 - 1) + 1)));
    private final PlanetMapImpl planetMap = (PlanetMapImpl) new PlanetMapImpl().initialize();
    private final RandomGame randomGame = new RandomGame();
    private final MarsRoverDestroy marsRoverDestroy = new MarsRoverDestroy();

    @GetMapping("/join")
    public String join(@RequestParam(value = "name", defaultValue = "Game") String playerName) {
        randomGame.generateObstacles();
        MarsRoverImpl marsRover = new MarsRoverImpl(randomGame.randomPosition(),planetMap);
        players.put(idPlayer,marsRover);
        System.out.println("This is the list of players: :"+ players);
        return String.format("idPlayer="+ idPlayer);
    }

    @GetMapping("rover/position")
    public String currentPosition (@RequestParam (value = "id" , defaultValue = "-1") Integer marsRover) {
        if (marsRover < 0) {
            return String.format("Sorry but the ID is wrong");
        }
        return String.format("This is the current position of the rover : " + players.get(marsRover).getPosition());
    }

    @GetMapping("rover/move")
    public String moving(@RequestParam (value = "id", defaultValue = "-1") Integer marsRover, @RequestParam (value = "command" , defaultValue = "f") String movementRover) {
        players.get(marsRover).move(movementRover);
        return String.format("This is the current position of the rover : " + players.get(marsRover).getPosition());
    }

    //Tir
    @GetMapping("rover/shoot")
    public String shoot(@RequestParam (value = "id", defaultValue = "-1") Integer marsRover) {
        marsRoverDestroy.destroy(players.get(marsRover).getPosition(), players.get(marsRover).getLaserRange() , planetMap);
        //players.get(marsRover).;
        return String.format("You just shot !");
    }

    //Récupérer la portée du tir
    @GetMapping("rover/shoot/range")
    public String shoot_range(@RequestParam (value = "id", defaultValue = "-1") Integer marsRover) {
        int laser_range = players.get(marsRover).getLaserRange();
        return "My laser range = "+laser_range;
    }

    @GetMapping("rover/detection")
    public String detection(@RequestParam (value = "id", defaultValue = "-1") Integer marsRover) {
      Position positionAround = players.get(marsRover).getPosition();
      String temp ="Position: ";
        for (HashMap.Entry player : players.entrySet()) {
            if (player.getKey() != marsRover) {
                Position pos =  ((MarsRoverImpl)player.getValue()).getPosition();
                if(Math.abs(pos.getX()-positionAround.getX()) <= 15 && Math.abs(pos.getY()-positionAround.getY()) <= 15)
                    temp += ((MarsRoverImpl)player.getValue()).getPosition();
                }
        }
        return temp;
    }

    @GetMapping("rover/status")
    public String status(@RequestParam (value = "id", defaultValue = "-1") Integer marsRover) {
        Boolean status = players.get(marsRover).isPlayerAlive();
        if (status) {
            return ("You are still alive");
        }
        return ("Sorry but you are dead");
    }



}
