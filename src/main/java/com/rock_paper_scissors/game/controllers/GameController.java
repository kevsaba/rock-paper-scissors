package com.rock_paper_scissors.game.controllers;

import com.rock_paper_scissors.game.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    @Autowired
    private GameServiceImpl gameServiceImpl;

    @GetMapping("/game")
    public String gameView(Model model) {
        setModelGame(model);
        return "game";
    }

    @GetMapping("/playRound")
    public String playRound(Model model) {
        gameServiceImpl.playGameRound();
        setModelGame(model);
        return "game";
    }

    @GetMapping("/restartCounter")
    public String restartCounter() {
        gameServiceImpl.restartGame();
        return "game";
    }

    @GetMapping("/results")
    public String resultsView(Model model) {
        model.addAttribute("resultBoard", gameServiceImpl.getResultsBoardService());
        return "results";
    }

    @RequestMapping("/")
    public void handleRequest() {
        throw new RuntimeException("test exception");
    }

    private void setModelGame(Model model) {
        model.addAttribute("gameStats", gameServiceImpl.getGameResult());
        model.addAttribute("rounds", gameServiceImpl.getRounds());
    }
}
