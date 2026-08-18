import java.util.ArrayList;
import java.util.List;

public class Player {
    private Integer id;
    private String name;
    private Character gameSymbol;
    private List<GameTurn> gameTurns;

    public Player(Integer id, String name, Character gameSymbol) {
        this.id = id;
        this.name = name;
        this.gameSymbol = gameSymbol;
        this.gameTurns = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGameSymbol() {
        return gameSymbol;
    }

    public void setGameSymbol(Character gameSymbol) {
        this.gameSymbol = gameSymbol;
    }

    public List<GameTurn> getGameTurns() {
        return gameTurns;
    }

    public void setGameTurns(List<GameTurn> gameTurns) {
        this.gameTurns = gameTurns;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
