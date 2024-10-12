package code.kunlabora.v3.game;

import code.kunlabora.v3.game.domain.Move;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("moves")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public boolean placeNextMove(@RequestBody Move move) {
        return gameService.placeNextMove(move);
    }
}
