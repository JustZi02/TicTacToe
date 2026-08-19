import java.util.List;

public class TicTacToeGame extends Game {

    private final static int COLUMNS = 3;
    private final static int ROWS = 3;

    private final static char BASE_SYMBOL = '-';
    private final static char O_SYMBOL = 'o';
    private final static char X_SYMBOL = 'x';

    private BoardService boardService;
    private Player player1;
    private Player player2;

    private Boolean isPlayer1Turn = true;
    private Boolean continueGame = true;

    @Override
    public void start() {
        initializeGame();
        while (continueGame) {
            boardService.drawBoard();
            playRound();
            roundFinalCheck();
        }
    }

    private void roundFinalCheck() {
        if (boardService.containsFreeCells()) {
            selectWinner();
        } else {
            boardService.drawBoard();
            continueGame = false;
        }
    }

    private void selectWinner() {
        char winnerSymbol = boardService.selectWinnerSymbol();
        if (winnerSymbol != boardService.board().getBaseSymbol()) {
            Player winner = PlayerService.getPlayerBySymbol(List.of(player1, player2), winnerSymbol);
            boardService.drawBoard();
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
        player1 = PlayerService.initializePlayer( O_SYMBOL);
        player2 = PlayerService.initializePlayer(X_SYMBOL);
    }

    private void boardInitializing() {
        boardService = new BoardService(new Board(COLUMNS, ROWS, BASE_SYMBOL));
        boardService.fulfillBoard();
    }

    private void playRound() {
        Player currentPlayer = getCurrentPlayer();

        System.out.printf("It's %s turn! (%s)", currentPlayer.getName(), currentPlayer.getGameSymbol());
        System.out.println();

        currentPlayer.getGameTurns().add(GameTurnService.makeGameTurn(boardService.board(),
                currentPlayer.getGameSymbol()));
        boardService.changeSymbol(currentPlayer.getGameTurns().getLast());

        changePlayersTurn();
    }

    private Player getCurrentPlayer() {
        return isPlayer1Turn ? player1 : player2;
    }

    private void changePlayersTurn() {
        isPlayer1Turn = !isPlayer1Turn;
    }
}
