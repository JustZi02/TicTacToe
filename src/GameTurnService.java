import java.util.Scanner;

public class GameTurnService {

    public static Scanner in = new Scanner(System.in);

    public static GameTurn makeGameTurn(Board board, Character symbol) {
        GameTurn gameTurn = new GameTurn();

        gameTurn.setSymbol(symbol);

        while (!gameTurn.getTurnCompleted()) {
            System.out.println("Enter column number (1, 2 ,3): ");
            gameTurn.setColumnIndex(Validator.validateInteger() - 1);

            System.out.println("Enter row number (1, 2 ,3): ");
            gameTurn.setRowIndex(Validator.validateInteger() - 1);

            gameTurn.setTurnCompleted(isValidIndex(gameTurn, board));
            System.out.println(gameTurn.getTurnCompleted() ? "Well done!" : "Invalid column or row number!");
        }
        return gameTurn;
    }

    public static Boolean isValidIndex(GameTurn gameTurn, Board board) {
        return isValidColumnIndex(gameTurn.getColumnIndex())
                && isValidRowIndex(gameTurn.getRowIndex())
                && isFreeIndex(gameTurn, board);
    }

    public static Boolean isValidColumnIndex(Integer columnIndex) {
        return columnIndex >= 0 && columnIndex <= 2;
    }

    public static Boolean isValidRowIndex(Integer rowIndex) {
        return rowIndex >= 0 && rowIndex <= 2;
    }

    public static Boolean isFreeIndex(GameTurn gameTurn, Board board) {
        return board.getBoardSymbolByIndex(gameTurn.getColumnIndex(), gameTurn.getRowIndex()) == board.getBaseSymbol();
    }
}
