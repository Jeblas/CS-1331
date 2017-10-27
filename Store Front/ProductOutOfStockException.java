/**
 * @author jblasco6
 * @version 1.0
 */
public class ProductOutOfStockException extends Exception {
    /**
     * Defualt constructor
     * @param product product that is out of stock
     */
    public ProductOutOfStockException(Product product) {
        super(product + " is out Stock.");
    }

    /**
     * Overloaded constructor
     * @param product product that is out of stock
     * @param input message to be returned
     */
    public ProductOutOfStockException(Product product, String input) {
        super(input + product);
    }
}
