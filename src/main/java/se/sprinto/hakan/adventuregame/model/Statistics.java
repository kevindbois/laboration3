package se.sprinto.hakan.adventuregame.model;

public class Statistics {
    private String playerName;
    private int score;

    public Statistics(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }
}

