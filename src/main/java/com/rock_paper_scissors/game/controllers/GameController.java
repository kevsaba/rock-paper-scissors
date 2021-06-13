package com.rock_paper_scissors.game.controllers;

import com.rock_paper_scissors.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/game")
    public String gameView(Model model, HttpServletRequest req) {
        model.addAttribute("gameStats", gameService.getGameStats());
        return "game";
    }

    @GetMapping("/playRound")
    public String playRound(Model model, HttpSession session) {
        gameService.playGame();
        model.addAttribute("gameStats", gameService.getGameStats());
        return "game";
    }

    @GetMapping("/restartCounter")
    public String restartCounter() {
        gameService.restartGame();
        return "game";
    }

    @GetMapping("/results")
    public String resultsView(Model model, HttpSession session) {
        model.addAttribute("resultBoard", gameService.getResultsBoardService());
        return "results";
    }

}
