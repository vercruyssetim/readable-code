package code.kunlabora.v3.game.domain;

import java.util.ArrayList;
import java.util.List;

public class Column {
    public static final int COLUMN_HEIGHT = 6;
    private final List<Token> tokenList;

    private Column(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public static Column createColumn() {
        return new Column(new ArrayList<>());
    }

    public void addToken(Token token) {
        if (tokenList.size() >= COLUMN_HEIGHT) {
            throw new RuntimeException("Column is full");
        }
        tokenList.add(token);
    }

    public Token getToken(int index) {
        if(index < 0 || index >= tokenList.size()) {
            return null;
        }
        return tokenList.get(index);
    }
}
