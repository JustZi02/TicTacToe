public record BoardService(Board board) {

    public void drawBoard() {
        for (int column = 0; column < board.getColumns(); column++) {
            for (int row = 0; row < board.getRows(); row++) {
                System.out.print(board.getBoard()[column][row]);
            }
            System.out.println();
        }
    }

    public void fulfillBoard() {

        for (int column = 0; column < board.getColumns(); column++) {
            for (int row = 0; row < board.getRows(); row++) {
                board.initializeBoardWithSymbol(column, row, board.getBaseSymbol());
            }
        }
    }

    public Boolean containsFreeCells() {
        for (int column = 0; column < board.getColumns(); column++) {
            for (int row = 0; row < board.getRows(); row++) {
                if (board.getBoard()[column][row] == board.getBaseSymbol()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void changeSymbol(GameTurn gameTurn) {
        board.initializeBoardWithSymbol(gameTurn.getColumnIndex(), gameTurn.getRowIndex(), gameTurn.getSymbol());
    }

    public Character selectWinnerSymbol() {

        Character result = board.getBaseSymbol();
        result = threeInRowWinner() != board.getBaseSymbol() ? threeInRowWinner() : result;
        result = threeInColumnWinner() != board.getBaseSymbol() ? threeInColumnWinner() : result;
        result = threeInDiagonalWinner() != board.getBaseSymbol() ? threeInDiagonalWinner() : result;

        return result;
    }

    private Character threeInRowWinner() {
        char winner = board.getBaseSymbol();

        for (int column = 0; column < board.getColumns() && winner == board.getBaseSymbol(); column++) {
            winner = board.getBoard()[0][column] == board.getBoard()[1][column] &&
                    board.getBoard()[1][column] == board.getBoard()[2][column] &&
                    board.getBoard()[0][column] != board.getBaseSymbol() ?
                    board.getBoard()[0][column] : winner;
        }

        return winner;
    }

    private Character threeInColumnWinner() {
        char winner = board.getBaseSymbol();

        for (int row = 0; row < board.getRows() && winner == board.getBaseSymbol(); row++) {
            winner = board.getBoard()[row][0] == board.getBoard()[row][1] &&
                    board.getBoard()[row][1] == board.getBoard()[row][2] &&
                    board.getBoard()[row][0] != board.getBaseSymbol() ?
                    board.getBoard()[row][0] : winner;
        }

        return winner;
    }

    private Character threeInDiagonalWinner() {

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
