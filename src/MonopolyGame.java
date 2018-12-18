import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
        players.get(players.size()-1).addObserver(this);
    }

    private void playRound() {
        for (Player player:
             players) {


            int distance = dice.nextInt(12) + 1;
            Square Location = player.getLocation();
            Square nextLocation = board.getNextSquare(Location, distance);
            try {
                nextLocation.landOn(player);
            }
            catch (BankruptException e) {
                System.exit(0);
            }

            // if (player.getLocation().ge)

        }

    }

    private String getWinner() {
        int highestNetWorth = 0;
        Player highestPlayer = null;
        for (Player player:
                players) {

            if (player.netWorth() > highestNetWorth) {
                highestNetWorth = player.netWorth();
                highestPlayer = player;
            }

        }
        return highestPlayer.getName();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        addPlayer("purple");
        addPlayer("red");

        Pane root = new VBox();

        Button rollButton = new Button("Roll");
        rollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playRound();
            }
        });
        root.getChildren().add(rollButton);


        for (Player player:
             players) {
            playersTFs.put(player.getName(), new TextField(player.getLocation().getName() + " : $" + player.netWorth()));
            playersTFs.get(player.getName()).setEditable(false);
            root.getChildren().add(playersTFs.get(player.getName()));
        }

        Scene scene = new Scene(root);
        primaryStage.setTitle("Monopoly");
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    @Override
    public void update(Observable o, Object arg) {
        Player player = (Player) arg;
        playersTFs.get(player.getName()).setText(player.getLocation().getName() + " : $" + player.netWorth());

    }
}
