import java.util.List;

public class TicTacToeGame extends Game {

    private final static Integer COLUMNS = 3;
    private final static Integer ROWS = 3;

    private final static Character BASE_SYMBOL = '-';
    private final static Character O_SYMBOL = 'o';
    private final static Character X_SYMBOL = 'x';

    private Board board;
    private Player player1;
    private Player player2;

    private Boolean isPlayer1Turn = true;
    private Boolean continueGame = true;

    @Override
    public void start() {
        initializeGame();
        while (continueGame) {
            BoardService.drawBoard(board);
            playRound();
            roundFinalCheck();
        }
    }

    private void roundFinalCheck() {
        if (BoardService.containsFreeCells(board)) {
            selectWinner();
            BoardService.drawBoard(board);
        } else {
            continueGame = false;
        }
    }

    private void selectWinner() {
        char winnerSymbol = BoardService.selectWinnerSymbol(board);
        if (winnerSymbol != board.getBaseSymbol()) {
            Player winner = PlayerService.getPlayerBySymbol(List.of(player1, player2), winnerSymbol);
            System.out.printf("Game end! %s is the winner!", winner.getName());
            System.out.println();
            continueGame = false;
        }
    }

    private void initializeGame() {
        playersInitializing();
        boardInitializing();
    }

    private void playersInitializing() {
        player1 = PlayerService.initializePlayer(1, O_SYMBOL);
        player2 = PlayerService.initializePlayer(2, X_SYMBOL);
    }

    private void boardInitializing() {
        board = BoardService.initializeBoard(ROWS, COLUMNS, BASE_SYMBOL);
    }

    private void playRound() {
        Player currentPlayer = getCurrentPlayer();

        System.out.printf("It's %s turn! (%s)", currentPlayer.getName(), currentPlayer.getGameSymbol());
        System.out.println();

        currentPlayer.getGameTurns().add(GameTurnService.makeGameTurn(board, currentPlayer.getGameSymbol()));
        BoardService.changeSymbol(currentPlayer.getGameTurns().getLast(), board);

        changePlayersTurn();
    }

    private Player getCurrentPlayer() {
        return isPlayer1Turn ? player1 : player2;
    }

    private void changePlayersTurn() {
        isPlayer1Turn = !isPlayer1Turn;
    }
}
