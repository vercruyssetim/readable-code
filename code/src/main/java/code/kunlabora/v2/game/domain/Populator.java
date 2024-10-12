package code.kunlabora.v2.game.domain;

import static code.kunlabora.v2.game.domain.Game.SIZE;

public class Populator {

    public void populate(int index, int column, int[] nextGame, int round) {
        if (index >= nextGame.length) {
            return;
        }
        if (nextGame[index + column] != 0) {
            putToken(nextGame, index + column - SIZE, round);
        } else if (index == SIZE * (SIZE - 2)) {
            putToken(nextGame, index + column, round);
        }
        populate(index + SIZE, column, nextGame, round);
    }

    private void putToken(int[] nextGame, int index, int round) {
        if (round % 2 == 1) {
            nextGame[index] = 1;
        } else {
            nextGame[index] = 2;
        }
    }
}
