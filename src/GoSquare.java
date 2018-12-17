/**
 * A GoSquare models the "collect $200" square in the game of Monopoly.
 *
 * @author D.L. Bailey, SCE, Carleton University
 * @version 1.01 March 26, 2006
 */
public class GoSquare extends Square {
    /**
     * Constructs a new GoSquare with the specified number.
     */
    public GoSquare(int number) {
        super("Go", number);
    }

    /**
     * Gives $200 to the specified player.
     */
    public void landOn(Player p) {
        p.setLocation(this);
        p.increaseCash(200);
    }
}