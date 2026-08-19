public class GameTurn {
    private int columnIndex;
    private int rowIndex;
    private char symbol;
    private boolean isTurnCompleted = false;

    public GameTurn() {

    }

    public Integer getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(Integer columnIndex) {
        this.columnIndex = columnIndex;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public Boolean getTurnCompleted() {
        return isTurnCompleted;
    }

    public void setTurnCompleted(Boolean turnCompleted) {
        isTurnCompleted = turnCompleted;
    }
}
