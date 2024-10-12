package code.kunlabora.v2.game;

import code.kunlabora.v2.game.domain.Checker.CountState;
import code.kunlabora.v2.game.domain.Game;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    private Game game = new Game(new int[42], 0);

    @Test
    void test() {
        Game givenGame = game
                .addToken(1)
                .addToken(1)
                .addToken(2)
                .addToken(2)
                .addToken(3)
                .addToken(3)
                .addToken(4);

        Assertions.assertThat(givenGame.check(0, 0, givenGame.getArray(), new CountState(0, 0))).isEqualTo("true");
    }

    @Test
    void test2() {
        Game givenGame = game
                .addToken(1)
                .addToken(1)
                .addToken(2)
                .addToken(3)
                .addToken(3)
                .addToken(2)
                .addToken(4)
                .addToken(4)
                .addToken(5)
                .addToken(5)
                .addToken(6)
                .addToken(6)
                .addToken(7);

        Assertions.assertThat(givenGame.check(0, 0, givenGame.getArray(), new CountState(0, 0))).isEqualTo("true");
    }
}