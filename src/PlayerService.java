import java.util.List;
import java.util.NoSuchElementException;

public class PlayerService {

    public static Player initializePlayer(Character playerSymbol) {
        System.out.print("Player's name: ");
        String name = Validator.validateString();

        return new Player(name, playerSymbol);
    }

    public static Player getPlayerBySymbol(List<Player> players, Character symbol) throws NoSuchElementException {
        for (var player : players) {
            if (symbol.equals(player.getGameSymbol())) {
                return player;
            }
        }
        throw new NoSuchElementException();
    }
}
