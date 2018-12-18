/**
 * Square is the superclass of the different types of
 * square on a Monopoly game board.
 *
 * @author D.L. Bailey, SCE, Carleton University
 * @version 2018 Schramm
 */
public abstract class Square {
    /**
     * The square's name.
     */
    private String name;

    /**
     * The square's number.
     */
    private int number;

    /**
     * Constructs a new Square with the specified name and number.
     */
    public Square(String name, int number) {
        this.name = name;
        this.number = number;
    }

    /**
     * Returns the name of this Square.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns this Square's number.
     */
    public int getNumber() {
        return number;
    }

    public abstract void landOn(Player p) throws BankruptException;


}