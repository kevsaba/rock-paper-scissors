package com.rock_paper_scissors.game;

import com.rock_paper_scissors.game.model.ResultsBoard;
import com.rock_paper_scissors.game.service.ResultsBoardServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(MockitoJUnitRunner.class)
public class ResultBoardServiceTests {

    public static final String PLAYER_1 = "Player 1";
    public static final String PLAYER_2 = "Player 2";
    private ResultsBoardServiceImpl boardService;

    @Before
    public void setUp() {
        boardService = new ResultsBoardServiceImpl();
    }


    @Test
    public void testUpdateResultsBoardP1Win() {
        //given
        //when
        boardService.updateResultsBoard(PLAYER_1);
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
        boardService.updateResultsBoard(PLAYER_2);
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
        boardService.updateResultsBoard(PLAYER_1);
        boardService.updateResultsBoard(null);
        //then
        final ResultsBoard resultsBoard = boardService.getResultsBoard();
        Assert.assertNotNull(resultsBoard);
        Assert.assertEquals(2, resultsBoard.getRoundsPlayed());
        Assert.assertEquals(1, resultsBoard.getPlayer1Wins());
        Assert.assertEquals(0, resultsBoard.getPlayer2Wins());
        Assert.assertEquals(1, resultsBoard.getPlayerDraw());
    }

    @Test
    public void testCounter() {
        for (int i = 0; i < 500; i++) {
            boardService.updateResultsBoard(PLAYER_1);
        }
        Assert.assertEquals(500, boardService.getResultsBoard().getRoundsPlayed());
    }

    @Test
    public void testCounterWithConcurrency() throws InterruptedException {
        int numberOfThreads = 1000;
        ExecutorService service = Executors.newFixedThreadPool(1000);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                boardService.updateResultsBoard(PLAYER_1);
                boardService.updateResultsBoard(PLAYER_2);
                latch.countDown();
            });
        }
        latch.await();
        Assert.assertEquals(numberOfThreads*2, boardService.getResultsBoard().getRoundsPlayed());
        Assert.assertEquals(numberOfThreads, boardService.getResultsBoard().getPlayer1Wins());
        Assert.assertEquals(numberOfThreads, boardService.getResultsBoard().getPlayer2Wins());
    }

}
