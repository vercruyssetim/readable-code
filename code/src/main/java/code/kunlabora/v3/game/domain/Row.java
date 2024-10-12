package code.kunlabora.v3.game.domain;

import java.util.List;

public class Row {
    public static final int VICTORY_CONDITION = 4;
    private final List<Token> tokenList;

    public Row(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public boolean hasVictoryFor(Token tokenToCheck) {
        int counter = 0;
        for(Token token: tokenList) {
            counter = nextCounterValue(tokenToCheck, token, counter);
            if(counter == VICTORY_CONDITION) {
                return true;
            }
        }
        return false;
    }

    private int nextCounterValue(Token tokenToCheck, Token token, int counter) {
        if (!tokenToCheck.equals(token)) {
            return 0;
        }
        return counter + 1;
    }

    @Override
    public String toString() {
        return tokenList.toString();
    }
}
