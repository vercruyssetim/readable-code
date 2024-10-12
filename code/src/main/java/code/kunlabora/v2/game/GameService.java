package code.kunlabora.v2.game;

import code.kunlabora.v2.game.domain.Checker.CountState;
import code.kunlabora.v2.game.GameController.Move;
import code.kunlabora.v2.game.domain.Game;
import org.springframework.stereotype.Component;

@Component
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public String placeNextMove(Move move) {
        Game game = gameRepository.getGame();

        Game nextGame = game.addToken(move.column());

        gameRepository.save(nextGame);

        return nextGame.check(0, 0, nextGame.getArray(), new CountState(0, 0));
    }
}
