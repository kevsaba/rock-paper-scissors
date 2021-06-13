package com.rock_paper_scissors.game;

import com.rock_paper_scissors.game.constants.GameOption;
import com.rock_paper_scissors.game.service.GameServiceImpl;
import com.rock_paper_scissors.game.service.ResultsBoardServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTests {

    public static final String PLAYER_1 = "Player 1";
    public static final String PLAYER_2 = "Player 2";
    @Mock
    private ResultsBoardServiceImpl boardService;

    private GameServiceImpl gameServiceImpl;

    @Before
    public void setUp() {
        gameServiceImpl = new GameServiceImpl(boardService);
    }

    @Test
    public void testGameServiceConstructor() {
        //given
        GameServiceImpl g;
        //when
        g = new GameServiceImpl(boardService);
        //then
        Assert.assertNotNull(g.getRounds());
        Assert.assertNotNull(g.getResultsBoardService());
    }

    @Test
    public void testPlayGameRound() {
        //given
        //when
        gameServiceImpl.playGameRound();
        //then
        Assert.assertNotNull(gameServiceImpl.getGameResult());
        verify(boardService, times(1)).updateResultsBoard(any());
    }

    @Test
    public void testGetWinnerP1wins() {
        //given
        //when
        String ret = gameServiceImpl.getWinner(GameOption.PAPER);
        //then
        Assert.assertEquals("Player 1", ret);
    }

    @Test
    public void testGetWinnerP2wins() {
        //given
        //when
        String ret = gameServiceImpl.getWinner(GameOption.SCISSORS);
        //then
        Assert.assertEquals(PLAYER_2, ret);
    }

    @Test
    public void testGetWinnerDraw() {
        //given
        //when
        String ret = gameServiceImpl.getWinner(GameOption.ROCK);
        //then
        Assert.assertNull(ret);
    }

    @Test
    public void testUpdateStatsValues() {
        //given
        //when
        gameServiceImpl.updateStatsValues(GameOption.SCISSORS, PLAYER_1);
        //then
        Assert.assertEquals(1, gameServiceImpl.getRounds());
        Assert.assertEquals(GameOption.SCISSORS, gameServiceImpl.getGameResult().getPlayer1played());
        Assert.assertEquals(GameOption.ROCK, gameServiceImpl.getGameResult().getPlayer2played());
        Assert.assertEquals(PLAYER_1, gameServiceImpl.getGameResult().getResult());
        verify(boardService, times(1)).updateResultsBoard(PLAYER_1);
    }

    @Test
    public void testRestartGame() {
        //given
        //when
        gameServiceImpl.restartGame();
        //then
        Assert.assertEquals(0, gameServiceImpl.getRounds());
    }


}
