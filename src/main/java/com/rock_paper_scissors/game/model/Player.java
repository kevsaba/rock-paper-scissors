package com.rock_paper_scissors.game.model;

import com.rock_paper_scissors.game.constants.GameOption;

public abstract class Player {
    final private String name;
    private GameOption optionSelected;

    protected Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract GameOption generateOption();

    public void setOptionSelected(GameOption optionSelected) {
        this.optionSelected = optionSelected;
    }

    public GameOption getOptionSelected() {
        return optionSelected;
    }

}
