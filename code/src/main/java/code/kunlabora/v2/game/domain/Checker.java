package code.kunlabora.v2.game.domain;

import static code.kunlabora.v2.game.domain.Game.SIZE;
import static code.kunlabora.v2.game.domain.Game.WIN_CONDITION;

public class Checker {
    public String check(int index, int column, int[] nextGame, CountState countState) {
        if (index >= SIZE - 1) {
            return "false";
        }
        if (column >= SIZE) {
            return check(++index, 0, nextGame, countState);
        }

        CountState nextCountState = calculateCountState(index, column, nextGame, countState);

        if (nextCountState.counter() == WIN_CONDITION) {
            return "true";
        }

        return check(index, ++column, nextGame, nextCountState);
    }

    private static CountState calculateCountState(int index, int column, int[] nextGame, CountState countState) {
        return switch (nextGame[SIZE * index + column]) {
            case 1 -> calculateCountState(1, countState);
            case 2 -> calculateCountState(2, countState);
            default -> new CountState(0, 0);
        };
    }

    private static CountState calculateCountState(int x, CountState countState) {
        if (x != countState.previous()) {
            return new CountState(1, x);
        }
        return new CountState(countState.counter() + 1, countState.previous());
    }

    public record CountState(int counter, int previous) {
    }
}
