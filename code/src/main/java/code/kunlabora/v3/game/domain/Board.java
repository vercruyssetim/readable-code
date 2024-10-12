package code.kunlabora.v3.game.domain;

import java.util.*;

public class Board {

    public static final int NUMBER_OF_COLUMNS = 7;
    private final List<Column> columns;

    private Board(List<Column> columns) {
        this.columns = columns;
    }

    public static Board createNewBoard() {
        List<Column> columns = new ArrayList<>();
        for(int index = 0; index < NUMBER_OF_COLUMNS; index++ ) {
            columns.add(Column.createColumn());
        }
        return new Board(columns);
    }

    public Column getColumn(int column) {
        return columns.get(column - 1);
    }

    public boolean hasVictory(Token token) {
        List<Row> rowList = getRows();
        for(Row row : rowList) {
            if(row.hasVictoryFor(token)) {
                return true;
            }
        }
        return false;
    }

    private List<Row> getRows() {
        List<Row> result = new ArrayList<>();
        for(int index = Column.COLUMN_HEIGHT; index >= 0; index--) {
            List<Token> row = new ArrayList<>();
            for(Column column : columns) {
                row.add(column.getToken(index));
            }
            result.add(new Row(row));
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Row row : getRows()) {
            builder.append(row.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
