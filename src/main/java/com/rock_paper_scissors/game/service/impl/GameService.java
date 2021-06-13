package com.rock_paper_scissors.game.service.impl;

import com.rock_paper_scissors.game.constants.GameOption;

public interface GameService {

    void playGameRound();

    void updateStatsValues(GameOption p1, String winner);

    String getWinner(GameOption p1);

    void restartGame();
}
