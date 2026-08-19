public class GameTurn {

    private int columnIndex;
    private int rowIndex;
    private char symbol;
    private boolean isTurnCompleted = false;

    public GameTurn() {

    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isTurnCompleted() {
        return isTurnCompleted;
    }

    public void setTurnCompleted(boolean turnCompleted) {
        isTurnCompleted = turnCompleted;
    }
}
