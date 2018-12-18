
import java.util.ArrayList;
import java.util.Observable;

/**
 * Models a player in a simulated game of Monopoly.
 *
 * @author D.L. Bailey, SCE, Carleton University
 * @version 2018 - Adapted by Schramm
 */
public class Player extends Observable implements Comparable  {
    /**
     * This player's name.
     */
    private String name;

    /**
     * The square where this player is located.
     */
    private Square location;

    /**
     * The amount of money this player has.
     */
    private int cash;

    /**
     * Constructs a new player with the specified name. The player is
     * placed in the board's starting square.
     */
    public Player(String name, Square startSquare) {
        this.name = name;
        this.cash = 1500;
        location = startSquare;
    }

    public String getName() {
        return this.name;
    }

    public Square getLocation() {
        return this.location;
    }

    public void setLocation(Square newLocation) {
        location = newLocation;
        setChanged();
        notifyObservers(this);
    }

    /**
     * Returns this player's net worth.
     */
    public int netWorth() {
        /* Currently, a player's net worth is the player's cash-on-hand.
         * Eventually, it will include the worth of any properties the player
         * owns.
         */
        return cash;
    }

    /**
     * Increases the amount of money held by this Player by the specified
     * amount.
     */
    public void increaseCash(int amount) {
        cash += amount;
    }

    /**
     * Reduces the amount of money held by this Player by the specified
     * amount.
     */
    public void decreaseCash(int amount) throws BankruptException {
        cash -= amount;

        if (cash < 0) throw new BankruptException(Math.abs(cash));
    }

    @Override
    public int compareTo(Object o) {

        final int LESS_THAN = -1;
        final int EQUAL = 0;
        final int GREATER_THAN = 1;
        if (this == o) return EQUAL;
        // if (this == null) Don't need this. Supposed to throw NullPointerException. Let it happen
        // if (this.getClass() != o.getClass()   Don't need this. Supposed to throw ClassCastException. Let it happen

        Player p = (Player) o;
        if (this.netWorth() == p.netWorth()) return EQUAL;
        else if (this.netWorth() > p.netWorth()) return GREATER_THAN;
        else return LESS_THAN;
    }

}

    