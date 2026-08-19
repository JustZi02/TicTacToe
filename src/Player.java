import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private final char gameSymbol;
    private final List<GameTurn> gameTurns;

    public Player(String name, Character gameSymbol) {
        this.name = name;
        this.gameSymbol = gameSymbol;
        this.gameTurns = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Character getGameSymbol() {
        return gameSymbol;
    }

    public List<GameTurn> getGameTurns() {
        return gameTurns;
    }
}
