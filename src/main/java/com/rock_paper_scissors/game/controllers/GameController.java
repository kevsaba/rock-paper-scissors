package com.rock_paper_scissors.game.controllers;

import com.rock_paper_scissors.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/game")
    public String gameView(Model model) {
        setModelGame(model);
        return "game";
    }

    @GetMapping("/playRound")
    public String playRound(Model model) {
        gameService.playGameRound();
        setModelGame(model);
        return "game";
    }

    @GetMapping("/restartCounter")
    public String restartCounter() {
        gameService.restartGame();
        return "game";
    }

    @GetMapping("/results")
    public String resultsView(Model model) {
        model.addAttribute("resultBoard", gameService.getResultsBoardService());
        return "results";
    }

    @RequestMapping("/")
    public void handleRequest() {
        throw new RuntimeException("test exception");
    }

    private void setModelGame(Model model) {
        model.addAttribute("gameStats", gameService.getGameResult());
        model.addAttribute("rounds", gameService.getRounds());
    }
}
