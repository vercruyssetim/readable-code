package code.kunlabora.v2.game;

import code.kunlabora.v2.game.domain.Game;
import org.springframework.stereotype.Component;

import static code.kunlabora.v2.game.domain.Game.SIZE;

@Component
public class GameRepository {
    private Game game = new Game(new int[SIZE * (SIZE - 1)], 0);

    public Game getGame() {
        return game;
    }

    public void save(Game game) {
        this.game = game;
    }
}
