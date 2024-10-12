package code.kunlabora.v2.game.domain;

import code.kunlabora.v2.game.domain.Checker.CountState;

import java.util.Arrays;

public class Game {
    public static final int SIZE = 7;
    public static final int WIN_CONDITION = 4;

    private final int[] array;
    private int round;

    public Game(int[] array, int round) {
        this.array = array;
        this.round = round;
    }

    public int[] getArray() {
        return array;
    }

    public Game addToken(int column) {
        round++;
        int[] nextGame = Arrays.copyOf(array, array.length);
        new Populator().populate(0, column - 1, nextGame, round);
        return new Game(nextGame, round);
    }

    public String check(int index, int column, int[] nextGame, CountState countState) {
        return new Checker().check(index, column, nextGame, countState);
    }
}
