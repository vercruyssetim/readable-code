package code.kunlabora.v3.game.domain;

public enum Player {
    PLAYER_1(Token.RED),
    PLAYER_2(Token.BLUE),;

    private final Token token;

    Player(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
}
