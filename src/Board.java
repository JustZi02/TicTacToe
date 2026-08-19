public class Board {

    private final Integer columns;
    private final Integer rows;
    private Character[][] board;
    private final Character baseSymbol;

    public Board(Integer columns, Integer rows, Character baseSymbol) {
        this.columns = columns;
        this.rows = rows;
        this.baseSymbol = baseSymbol;
        board = new Character[columns][rows];
    }

    public Integer getColumns() {
        return columns;
    }

    public Integer getRows() {
        return rows;
    }

    public Character getBaseSymbol() {
        return baseSymbol;
    }

    public Character[][] getBoard() {
        return board;
    }

    public void initializeBoardWithSymbol(int column, int row, Character symbol) {
        board[column][row] = symbol;
    }

    public Character getBoardSymbolByIndex(int column, int row) {
        return board[column][row];
    }


    public void setBoard(Character[][] board) {
        this.board = board;
    }
}
