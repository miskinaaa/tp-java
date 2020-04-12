package com.esiea.tp4A.domain;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class serverHTTP {
    private final int PORT = 8080;

    public serverHTTP() {}

    public void startHTTPserver() throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/api/player", new PlayerHandler());
        server.start();
    }
}
