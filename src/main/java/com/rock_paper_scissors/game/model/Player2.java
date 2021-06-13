package com.rock_paper_scissors.game.model;

import com.rock_paper_scissors.game.constants.GameOption;

public class Player2 extends Player {

    public Player2() {
        super("Player 2");
    }

    @Override
    public GameOption generateOption() {
        setOptionSelected(GameOption.ROCK);
        return getOptionSelected();
    }
}
