/**
 * @author jblasco6
 * @version 1.0
 */
public class InsufficientFundsException extends Exception {
    /**
     * Default constructor for IFE
     */
    public InsufficientFundsException() {
        super("Funds are insufficient");
    }

    /**
     * Overloaded Constuctor
     * @param msg Exception message
     */
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}
