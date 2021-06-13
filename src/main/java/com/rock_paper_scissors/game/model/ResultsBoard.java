package com.rock_paper_scissors.game.model;

public class ResultsBoard {
    private long roundsPlayed;
    private int player1Wins;
    private int player2Wins;
    private int playerDraw;

    public long getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(long roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public int getPlayer1Wins() {
        return player1Wins;
    }

    public int getPlayer2Wins() {
        return player2Wins;
    }

    public int getPlayerDraw() {
        return playerDraw;
    }

    public void incrementPlayer1Win() {
        player1Wins++;
    }

    public void incrementPlayer2Win() {
        player2Wins++;
    }

    public void incrementPlayerDraw() {
        playerDraw++;
    }
}
