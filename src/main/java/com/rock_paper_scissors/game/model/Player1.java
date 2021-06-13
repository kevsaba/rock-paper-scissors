package com.rock_paper_scissors.game.model;

import com.rock_paper_scissors.game.constants.GameOption;

public class Player1 extends Player {

    public Player1() {
        super("Player 1");
    }

    @Override
    public GameOption generateOption() {
        setOptionSelected(GameOption.randomGameOption());
        return getOptionSelected();
    }
}
