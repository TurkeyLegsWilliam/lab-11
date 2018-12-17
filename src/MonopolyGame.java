import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.*;

public class MonopolyGame extends Application implements Observer {

    private int rounds;
    private Board board;
    private Random dice;
    private ArrayList<Player> players;
    private HashMap<String, TextField> playersTFs;

    public MonopolyGame () {
        rounds = 10;
        board = new Board();
        dice = new Random();
        players = new ArrayList<>();
        playersTFs = new HashMap<>();


    }

    private void addPlayer (String name) {
        players.add(new Player(name,board.startingSquare()));
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
