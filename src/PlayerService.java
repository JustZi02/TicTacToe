import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PlayerService {

    public static Scanner scanner = new Scanner(System.in);
    public static Player initializePlayer(Character playerSymbol) {
        System.out.print("Player's name: ");
        String name = scanner.nextLine();

        return new Player(name, playerSymbol);
    }

    public static Player getPlayerBySymbol(List<Player> players, Character symbol) throws NoSuchElementException {
        for(var player : players) {
            if(symbol.equals(player.getGameSymbol())) {
                return player;
            }
        }
        throw new NoSuchElementException();
    }
}
