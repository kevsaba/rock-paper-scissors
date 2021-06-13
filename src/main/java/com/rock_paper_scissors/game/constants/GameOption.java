package com.rock_paper_scissors.game.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum GameOption {
    ROCK, PAPER, SCISSORS;

    private static final List<GameOption> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static GameOption randomGameOption() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public int compare(GameOption other) {
        if (this == ROCK && other == PAPER || this == SCISSORS && other == ROCK || this == PAPER && other == SCISSORS) {
            return -1;
        } else if (this == ROCK && other == SCISSORS || this == SCISSORS && other == PAPER || this == PAPER && other == ROCK) {
            return 1;
        } else {
            return 0;
        }
    }
}
