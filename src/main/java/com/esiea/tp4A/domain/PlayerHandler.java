package com.esiea.tp4A.domain;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerHandler implements HttpHandler {
    private List<String> playersName = new ArrayList<>();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        URI request = exchange.getRequestURI();
        String[] pathVariable = request.getPath().split("/");
        InputStream is;
        OutputStream os;
        JSONObject jsonObject = new JSONObject();


        if(requestMethod.equalsIgnoreCase("GET")) {
            if(pathVariable[3] != null) {
                Headers respenseHeaders = exchange.getResponseHeaders();
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, );
                os = exchange.getResponseBody();
                os.write();
                os.close();
            } else {
                String response = "Player not registered";
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_NOT_FOUND, response.getBytes().length);
                os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        } else if (requestMethod.equalsIgnoreCase("POST")) {
            if(pathVariable[3] != null && !playersName.contains(pathVariable[3])) {
                Headers respenseHeaders = exchange.getResponseHeaders();
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_CREATED, );
                os = exchange.getResponseBody();
                os.write();
                os.close();
            } else {
                String response = "Player already registered";
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_CONFLICT, response.getBytes().length);
                os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        } else if (requestMethod.equalsIgnoreCase("PATCH")) {
            //player move position
            JSONObject jo = new JSONObject();

            JSONObject position = new JSONObject();
            position.put("x", player.getX());
            position.put("y", player.getY());
            position.put("direction", player.getDirection());

            JSONObject players = new JSONObject();
            player.put("name", player.getName());
            player.put("status", player.isAlive());
            player.put("position", position);
            player.put("laser-range", player.getLaserRange());

            //boucle sur ApiImpl.getObstaclesPlayers() qui sépare
            // les joueurs est les obstcles dans 2 lists

            JSONArray obstaclesArray = new JSONArray();
            // boucle sur listObstacles et crée un JSONObject qui contient
            // les infos de l'obstacle
            // puis met le JSONObject dans le JSONArray

            JSONArray playersArray = new JSONArray();
            // boucle sur listPlayers et crée un JSONObject qui contient
            // les infos d'un joueur
            // puis met le JSONObject dans le JSONArray

            JSONObject localMap = new JSONObject();
            localMap.put("obstacles" ,obstaclesArray);
            localMap.put("players" ,playersArray);

            JSONObject traceResponse = new JSONObject();
            traceResponse.put("player", players);
            traceResponse.put("local-map",localMap);

            Headers respenseHeaders = exchange.getResponseHeaders();
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, traceResponse.toString().getBytes().length);
            os = exchange.getResponseBody();
            os.write(traceResponse.toString().getBytes());
            os.close();
        } else {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_NOT_FOUND, -1);
        }
        exchange.close();
    }
}
