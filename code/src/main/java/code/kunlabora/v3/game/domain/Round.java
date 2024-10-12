package code.kunlabora.v3.game.domain;

public class Round {

    private Player player;

    private Round(Player player) {
        this.player = player;
    }

    public static Round newRound() {
        return new Round(Player.PLAYER_1);
    }

    public Token getToken() {
        return player.getToken();
    }

    public void nextRound() {
        this.player = switch (player) {
            case PLAYER_1 -> Player.PLAYER_2;
            case PLAYER_2 -> Player.PLAYER_1;
        };
    }
}
