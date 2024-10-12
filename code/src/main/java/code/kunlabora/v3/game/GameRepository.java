package code.kunlabora.v3.game;

import code.kunlabora.v3.game.domain.Game;
import org.springframework.stereotype.Component;

@Component
public class GameRepository {
    private Game game = Game.createNewGame();

    public Game getGame() {
        return game;
    }

    public void save(Game game) {
        this.game = game;
    }
}
