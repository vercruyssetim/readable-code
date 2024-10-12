package code.kunlabora.v3.game.domain;

public class Game {

    private final Round round;
    private final Board board;

    private Game(Round round, Board board) {
        this.round = round;
        this.board = board;
    }

    public static Game createNewGame() {
        return new Game(Round.newRound(), Board.createNewBoard());
    }

    public boolean addMove(Move move) {
        Column column = board.getColumn(move.column());
        column.addToken(round.getToken());
        boolean hasVictory = board.hasVictory(round.getToken());
        if(hasVictory) {
            return true;
        }
        round.nextRound();
        return false;
    }

    public String toString() {
        return board.toString();
    }
}
