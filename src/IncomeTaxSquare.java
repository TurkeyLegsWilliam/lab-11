/**
 * An IncomeTaxSquare models squares in the game of Monopoly where income
 * tax is collected from players.
 * 
 * @author D.L. Bailey, SCE, Carleton University 
 * @version 1.01 March 26, 2006
 */
public class IncomeTaxSquare extends Square
{
    private int maximumTax;
    
     /**
     * Constructs a new IncomeTaxSquare with the specified number.
     */   
    public IncomeTaxSquare(int number)
    {
        super("Income Tax", number);
        maximumTax = 200;
    }

    /**
     * Collects income tax from the specified player. The tax 
     * payable is $200 or 10% of the player's net worth, whichever
     * is less.
     */
    public void landOn(Player p) throws BankruptException {
        p.setLocation(this);
        int taxPayable = p.netWorth() / 10;
        if (taxPayable > maximumTax)
            taxPayable = maximumTax;
        p.decreaseCash(taxPayable);
    }   
}