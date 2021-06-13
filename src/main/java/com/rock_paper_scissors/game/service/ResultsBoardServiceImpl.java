package com.rock_paper_scissors.game.service;

import com.rock_paper_scissors.game.model.ResultsBoard;
import com.rock_paper_scissors.game.service.impl.ResultsBoardService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ResultsBoardServiceImpl implements ResultsBoardService {

    public static final String PLAYER_1 = "Player 1";
    public static final String PLAYER_2 = "Player 2";
    private final ResultsBoard resultsBoard;
    private long rounds = 0;

    public ResultsBoardServiceImpl() {
        this.resultsBoard = new ResultsBoard();
    }

    public synchronized void updateResultsBoard(String winner) {
        long rounds = incrementAndGetRounds();
        resultsBoard.setRoundsPlayed(rounds);
        if (PLAYER_1.equals(winner)) {
            resultsBoard.incrementPlayer1Win();
        } else if (PLAYER_2.equals(winner)) {
            resultsBoard.incrementPlayer2Win();
        } else {
            resultsBoard.incrementPlayerDraw();
        }
    }

    private long incrementAndGetRounds() {
        return ++rounds;
    }

    public ResultsBoard getResultsBoard() {
        return this.resultsBoard;
    }

}
