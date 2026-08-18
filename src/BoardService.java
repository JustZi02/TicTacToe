public class BoardService {

    public static void drawBoard(Board board) {
        for(int column = 0; column < board.getColumns(); column++) {
            for(int row = 0; row < board.getRows(); row++) {
                System.out.print(board.getBoard()[column][row]);
            }
            System.out.println();
        }
    }

    public static Board initializeBoard(Integer rows, Integer columns, Character baseSymbol){
        Board board = new Board(columns, rows, baseSymbol);
        fulfillBoard(board);
        return board;
    }

    public static void fulfillBoard(Board board) {

        for(int column = 0; column < board.getColumns(); column++) {
            for(int row = 0; row < board.getRows(); row++) {
                board.initializeBoardWithSymbol(column, row, board.getBaseSymbol());
            }
        }
    }

    public static Boolean containsFreeCells(Board board) {
        for(int column = 0; column < board.getColumns(); column++) {
            for(int row = 0; row < board.getRows(); row++) {
                if (board.getBoard()[column][row] == board.getBaseSymbol()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void changeSymbol(GameTurn gameTurn, Board board) {
        board.initializeBoardWithSymbol(gameTurn.getColumnIndex(), gameTurn.getRowIndex(), gameTurn.getSymbol());
    }

    public static Character selectWinnerSymbol(Board board){

        Character result = board.getBaseSymbol();
        result = threeInRowWinner(board) != board.getBaseSymbol() ? threeInRowWinner(board) : result;
        result = threeInColumnWinner(board) != board.getBaseSymbol() ? threeInColumnWinner(board) : result;
        result = threeInDiagonalWinner(board) != board.getBaseSymbol() ? threeInDiagonalWinner(board) : result;

        return result;
    }

    private static Character threeInRowWinner(Board board) {
        char winner = board.getBaseSymbol();

        for(int column = 0; column < board.getColumns() && winner == board.getBaseSymbol(); column++) {
            winner = board.getBoard()[0][column] == board.getBoard()[1][column] &&
                    board.getBoard()[1][column] == board.getBoard()[2][column] &&
                    board.getBoard()[0][column] != board.getBaseSymbol() ?
                    board.getBoard()[0][column] : winner;
        }

        return winner;
    }

    private static Character threeInColumnWinner(Board board) {
        char winner = board.getBaseSymbol();

        for(int row = 0; row < board.getRows() && winner == board.getBaseSymbol(); row++) {
            winner = board.getBoard()[row][0] == board.getBoard()[row][1] &&
                    board.getBoard()[row][1] == board.getBoard()[row][2] &&
                    board.getBoard()[row][0] != board.getBaseSymbol() ?
                    board.getBoard()[row][0] : winner;
        }

        return winner;
    }

    private static Character threeInDiagonalWinner(Board board) {

        char winner = board.getBaseSymbol();

        winner = board.getBoard()[0][0] == board.getBoard()[1][1] &&
                board.getBoard()[1][1] == board.getBoard()[2][2] &&
                board.getBoard()[0][0] != board.getBaseSymbol() ?
                board.getBoard()[0][0] : winner;

        winner = board.getBoard()[0][2] == board.getBoard()[1][1] &&
                board.getBoard()[1][1] == board.getBoard()[2][0] &&
                board.getBoard()[0][2] != board.getBaseSymbol() ?
                board.getBoard()[0][2] : winner;

        return winner;
    }

}
