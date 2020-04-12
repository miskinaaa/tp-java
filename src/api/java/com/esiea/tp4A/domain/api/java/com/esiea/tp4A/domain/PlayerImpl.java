package api.java.com.esiea.tp4A.domain;
import main.java.com.esiea.tp4A.domain.Position;

import java.util.Set;

public class PlayerImpl implements Player {
    private Api api;
    private String playerName;

    private PlayerImpl(Api game, String playerName) {
        this.api = game;
        this.playerName = playerName;
    }

    public PlayerImpl() {
        this.api = null;
        this.playerName = null;
    }
    @Override
    public Player initialize(Api api, String playerName) {
        return new PlayerImpl(api, playerName);
    }
    @Override
    public Position getPosition() {
        if (this.api == null) {
            return null;
        }
        return this.api.getPosition(this.playerName);
    }
    @Override
    public Set<Position> getObstaclesPlayers() {
        if (this.api == null) {
            return null;
        }
        return this.api.getObstaclesPlayers(this.playerName);
    }
    @Override
    public int getLaserRange() {
        if (this.api == null) {
            return 0;
        }
        return this.api.getLaserRange(this.playerName);
    }
    @Override
    public Position move(String command) {
        if (this.api == null) {
            return null;
        }
        return this.api.movePlayer(this.playerName, command);
    }
    @Override
    public boolean isAlive() {
        if (this.api == null) {
            return false;
        }
        return this.api.isPlayerAlive(this.playerName);
    }
}
