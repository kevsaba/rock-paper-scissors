package com.rock_paper_scissors.game;

import com.rock_paper_scissors.game.constants.GameOption;
import com.rock_paper_scissors.game.model.GameTrack;
import com.rock_paper_scissors.game.model.ResultsBoard;
import com.rock_paper_scissors.game.service.ResultsBoardService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTrackTests {
    public static final String PLAYER_1 = "Player 1";
    public static final String PLAYER_2 = "Player 2";
    private GameTrack gameTrack;

    @Test
    public void testUpdateResultsBoardP1Win() {
        //given
        gameTrack = new GameTrack(GameOption.SCISSORS, GameOption.ROCK, PLAYER_1);
        //when
        gameTrack.clear();
        //then
        Assert.assertNotNull(gameTrack.getResult());
        Assert.assertNull(gameTrack.getPlayer1played());
        Assert.assertNull(gameTrack.getPlayer2played());
    }


}
