package com.rock_paper_scissors.game;

import com.rock_paper_scissors.game.constants.GameOption;
import com.rock_paper_scissors.game.model.GameTrack;
import com.rock_paper_scissors.game.model.ResultsBoard;
import com.rock_paper_scissors.game.service.GameService;
import com.rock_paper_scissors.game.service.ResultsBoardService;
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
    private ResultsBoardService boardService;

    private GameService gameService;

    @Before
    public void setUp() {
        gameService = new GameService(boardService);
    }

    @Test
    public void testGameServiceConstructor() {
        //given
        GameService g;
        //when
        g = new GameService(boardService);
        //then
        Assert.assertNotNull(g.getRounds());
        Assert.assertNotNull(g.getResultsBoardService());
    }

    @Test
    public void testPlayGameRound() {
        //given
        //when
        gameService.playGameRound();
        //then
        Assert.assertNotNull(gameService.getGameResult());
        verify(boardService, times(1)).updateResultsBoard(any());
    }

    @Test
    public void testGetWinnerP1wins() {
        //given
        //when
        String ret = gameService.getWinner(GameOption.PAPER);
        //then
        Assert.assertEquals("Player 1", ret);
    }

    @Test
    public void testGetWinnerP2wins() {
        //given
        //when
        String ret = gameService.getWinner(GameOption.SCISSORS);
        //then
        Assert.assertEquals(PLAYER_2, ret);
    }

    @Test
    public void testGetWinnerDraw() {
        //given
        //when
        String ret = gameService.getWinner(GameOption.ROCK);
        //then
        Assert.assertNull(ret);
    }

    @Test
    public void testUpdateStatsValues() {
        //given
        //when
        gameService.updateStatsValues(GameOption.SCISSORS, PLAYER_1);
        //then
        Assert.assertEquals(1, gameService.getRounds());
        Assert.assertEquals(GameOption.SCISSORS, gameService.getGameResult().getPlayer1played());
        Assert.assertEquals(GameOption.ROCK, gameService.getGameResult().getPlayer2played());
        Assert.assertEquals(PLAYER_1, gameService.getGameResult().getResult());
        verify(boardService, times(1)).updateResultsBoard(PLAYER_1);
    }

    @Test
    public void testRestartGame() {
        //given
        //when
        gameService.restartGame();
        //then
        Assert.assertEquals(0, gameService.getRounds());
    }


}
