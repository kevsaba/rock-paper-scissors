package com.rock_paper_scissors.game.model;

import com.rock_paper_scissors.game.constants.GameOption;

public class GameTrack {
    private GameOption player1played;
    private GameOption player2played;
    private String result;

    public GameTrack(GameOption player1played, GameOption player2played, String result) {
        this.player1played = player1played;
        this.player2played = player2played;
        this.result = result;
    }

    public GameOption getPlayer1played() {
        return player1played;
    }

    public GameOption getPlayer2played() {
        return player2played;
    }

    public String getResult() {
        return result == null ? "Draw" : result;
    }

    public void clear() {
        this.player1played = null;
        this.player2played = null;
        this.result = null;
    }
}
