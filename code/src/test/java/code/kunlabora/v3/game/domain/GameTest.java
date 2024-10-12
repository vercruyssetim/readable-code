package code.kunlabora.v3.game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private Game game = Game.createNewGame();

    @Test
    void testForDirectVictory() {
        game.addMove(new Move(1));
        game.addMove(new Move(1));
        game.addMove(new Move(2));
        game.addMove(new Move(2));
        game.addMove(new Move(3));
        game.addMove(new Move(3));

        boolean victory = game.addMove(new Move(4));


        assertThat(victory).isTrue();
    }

    @Test
    void testForBlockedVictory() {
        game.addMove(new Move(1));
        game.addMove(new Move(1));
        game.addMove(new Move(2));
        game.addMove(new Move(3));
        game.addMove(new Move(3));
        game.addMove(new Move(2));
        game.addMove(new Move(4));
        game.addMove(new Move(4));
        game.addMove(new Move(5));
        game.addMove(new Move(5));
        game.addMove(new Move(6));
        game.addMove(new Move(6));

        boolean victory = game.addMove(new Move(7));

        assertThat(victory).isTrue();
    }

}