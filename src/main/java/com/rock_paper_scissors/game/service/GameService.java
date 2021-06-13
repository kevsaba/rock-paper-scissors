package com.rock_paper_scissors.game.service;

import com.rock_paper_scissors.game.constants.GameOption;
import com.rock_paper_scissors.game.model.GameTrack;
import com.rock_paper_scissors.game.model.Player;
import com.rock_paper_scissors.game.model.Player1;
import com.rock_paper_scissors.game.model.Player2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GameService {

    @Autowired
    private ResultsBoardService resultsBoardService;

    private final List<GameTrack> gameStats;
    private final Player1 player1;
    private final Player2 player2;

    public GameService() {
        this.gameStats = new ArrayList<>();
        this.player1 = new Player1();
        this.player2 = new Player2();
    }

    public void playGame() {
        final GameOption player1Selection = player1.generateOption();
        final GameOption player2Selection = player2.generateOption();
        Player winner = null;
        if (player1Selection.compare(player2Selection) > 0) {
            winner = player1;
        } else if (player1Selection.compare(player2Selection) < 0) {
            winner = player2;
        }
        gameStats.add(new GameTrack(player1Selection, player2Selection, winner));
        resultsBoardService.updateResultsBoard(winner == null ? null : winner.getName());
    }

    public List<GameTrack> getGameStats() {
        return Collections.unmodifiableList(gameStats);
    }

    public void restartGame() {
        gameStats.clear();
    }

    public ResultsBoardService getResultsBoardService() {
        return resultsBoardService;
    }

}
