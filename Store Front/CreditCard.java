/**
 * @author jblasco6
 * @version 1.0
 */
public class CreditCard {

    private double balance;

    /**
     * Constructor for CreditCard object
     * sets balance to tBalance
     * @param tBalance starting balace of the Card
     */
    public CreditCard(double tBalance) {
        balance = tBalance;
    }

    /**
     *
     * @param amount the amount to charge to the card
     * @throws InsufficientFundsException card balance is less than amount
     */
    public void pay(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException();
        }
        balance -= amount;
    }
}
