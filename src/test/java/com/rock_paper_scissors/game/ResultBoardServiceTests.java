package com.rock_paper_scissors.game;

import com.rock_paper_scissors.game.model.ResultsBoard;
import com.rock_paper_scissors.game.service.ResultsBoardService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResultBoardServiceTests {

    public static final String PLAYER_1 = "Player 1";
    public static final String PLAYER_2 = "Player 2";
    private ResultsBoardService boardService;

    @Before
    public void setUp() {
        boardService = new ResultsBoardService();
    }


    @Test
    public void testUpdateResultsBoardP1Win() {
        //given
        //when
        boardService.updateResultsBoard(ResultsBoardService.PLAYER_1);
        //then
        final ResultsBoard resultsBoard = boardService.getResultsBoard();
        Assert.assertNotNull(resultsBoard);
        Assert.assertEquals(1, resultsBoard.getRoundsPlayed());
        Assert.assertEquals(1, resultsBoard.getPlayer1Wins());
        Assert.assertEquals(0, resultsBoard.getPlayer2Wins());
        Assert.assertEquals(0, resultsBoard.getPlayerDraw());
    }

    @Test
    public void testUpdateResultsBoardP2Win() {
        //given
        //when
        boardService.updateResultsBoard(ResultsBoardService.PLAYER_2);
        //then
        final ResultsBoard resultsBoard = boardService.getResultsBoard();
        Assert.assertNotNull(resultsBoard);
        Assert.assertEquals(1, resultsBoard.getRoundsPlayed());
        Assert.assertEquals(0, resultsBoard.getPlayer1Wins());
        Assert.assertEquals(1, resultsBoard.getPlayer2Wins());
        Assert.assertEquals(0, resultsBoard.getPlayerDraw());
    }

    @Test
    public void testUpdateResultsBoardDraw() {
        //given
        //when
        boardService.updateResultsBoard(null);
        //then
        final ResultsBoard resultsBoard = boardService.getResultsBoard();
        Assert.assertNotNull(resultsBoard);
        Assert.assertEquals(1, resultsBoard.getRoundsPlayed());
        Assert.assertEquals(0, resultsBoard.getPlayer1Wins());
        Assert.assertEquals(0, resultsBoard.getPlayer2Wins());
        Assert.assertEquals(1, resultsBoard.getPlayerDraw());
    }

    @Test
    public void testUpdateResultsBoardDrawAndP1Win() {
        //given
        //when
        boardService.updateResultsBoard(ResultsBoardService.PLAYER_1);
        boardService.updateResultsBoard(null);
        //then
        final ResultsBoard resultsBoard = boardService.getResultsBoard();
        Assert.assertNotNull(resultsBoard);
        Assert.assertEquals(2, resultsBoard.getRoundsPlayed());
        Assert.assertEquals(1, resultsBoard.getPlayer1Wins());
        Assert.assertEquals(0, resultsBoard.getPlayer2Wins());
        Assert.assertEquals(1, resultsBoard.getPlayerDraw());
    }

}
