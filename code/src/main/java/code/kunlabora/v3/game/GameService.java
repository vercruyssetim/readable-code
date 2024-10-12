package code.kunlabora.v3.game;

import code.kunlabora.v3.game.domain.Game;
import code.kunlabora.v3.game.domain.Move;
import org.springframework.stereotype.Component;

@Component
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public boolean placeNextMove(Move move) {
        Game game = gameRepository.getGame();

        return game.addMove(move);
    }
}
