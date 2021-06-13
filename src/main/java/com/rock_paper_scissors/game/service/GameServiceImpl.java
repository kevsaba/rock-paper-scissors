package com.rock_paper_scissors.game.service;

import com.rock_paper_scissors.game.constants.GameOption;
import com.rock_paper_scissors.game.model.GameTrack;
import com.rock_paper_scissors.game.service.impl.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GameServiceImpl implements GameService {

    public static final String PLAYER_1 = "Player 1";
    public static final String PLAYER_2 = "Player 2";
    private final ResultsBoardServiceImpl resultsBoardService;
    private GameTrack gameResult;
    private long rounds;

    @Autowired
    public GameServiceImpl(ResultsBoardServiceImpl resultsBoardService) {
        this.resultsBoardService = resultsBoardService;
        this.rounds = 0L;
    }

    public void playGameRound() {
        final GameOption p1 = GameOption.randomGameOption();
        updateStatsValues(p1, getWinner(p1));
    }


    public void updateStatsValues(GameOption p1, String winner) {
        ++rounds;
        gameResult = new GameTrack(p1, GameOption.ROCK, winner);
        resultsBoardService.updateResultsBoard(winner);
    }

    public String getWinner(GameOption p1) {
        String winner = null;
        if (p1.compare(GameOption.ROCK) > 0) {
            winner = PLAYER_1;
        } else if (p1.compare(GameOption.ROCK) < 0) {
            winner = PLAYER_2;
        }
        return winner;
    }

    public void restartGame() {
        if (gameResult != null) {
            gameResult.clear();
        }
        rounds = 0L;
    }

    public GameTrack getGameResult() {
        return gameResult;
    }

    public ResultsBoardServiceImpl getResultsBoardService() {
        return resultsBoardService;
    }

    public long getRounds() {
        return rounds;
    }

}
