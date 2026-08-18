public class GameTurn {
    private Integer columnIndex;
    private Integer rowIndex;
    private Character symbol;
    private Boolean isTurnCompleted = false;

    public GameTurn(Integer columnIndex, Integer rowIndex) {
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
    }
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
