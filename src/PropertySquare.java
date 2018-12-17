/**
 * A PropertySquare is a concrete implementation of a Square that
 * acts as a placeholder for other types of squares in a more complete
 * implementation of Monopoly. No action occurs when a player lands
 * on a PropertySquare.
 *
 * @author D.L. Bailey, SCE, Carleton University
 * @version 2018 Schramm
 */
public class PropertySquare extends Square {
    private Player owner;
    private int price;
    private int rent;

    public PropertySquare(String name, int number, int price, int rent) {
        super(name, number);
        this.price = price;
        this.rent = rent;
        owner = null;
    }

    /**
     * For a Property Square, when a player lands on a square
     * - If the property is available, that player must buy the property if they have sufficient funds
     * - If the property is already owner, that player must pay the owner its rent, to the best of their ability
     *
     * @throws java.lang.Exception if the player cannot afford the rent.
     */
    public void landOn(Player p) throws BankruptException {
        p.setLocation(this);
        if (owner == null) {
            // Player buys property if they can afford it
            if (p.netWorth() > price) {
                p.decreaseCash(price);
                //board.addOwner(this, p);
                this.owner = p;
            }
        } else { // Some other player owns this square
            // Player p pays rent to the owner (if they can)
            if (p.netWorth() > rent) {
                p.decreaseCash(rent);
                owner.increaseCash(rent);
            } else {
                int amount = p.netWorth();
                p.decreaseCash(amount);
                owner.increaseCash(amount);
                throw new BankruptException(rent - amount);
            }
        }
    }
}