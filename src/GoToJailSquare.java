/**
 * A GoToJail square models the square in the game of Monopoly that
 * causes players to immediately jump to the square that represents
 * the game's jail.
 *
 * @author D.L. Bailey, SCE, Carleton University
 * @version 1.01 March 26, 2006
 */
public class GoToJailSquare extends Square {
    /* The jail square. */
    private Square jailSquare;

    /**
     * Constructs a new GoToJailSquare with the specified number.
     */
    public GoToJailSquare(int number, Square jailSquare) {
        super("Go To Jail", number);
        this.jailSquare = jailSquare;
    }

    /**
     * Moves the specified player directly to the jail square.
     */
    public void landOn(Player p) {
        p.setLocation(jailSquare);
    }
}