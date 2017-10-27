/**
 *
 * @author jblasco6
 * @version 1.0
 */
public abstract class Product {
    private String color;
    private boolean isLimitedEdition;
    private double price;

    /**
     * Constructor
     * @param tColor color of the product
     * @param tIsLimited if the product is limited edition
     * @param tCost the price of the product
     */
    public Product(String tColor, boolean tIsLimited, double tCost) {
        color = tColor;
        isLimitedEdition = tIsLimited;
        price = tCost;
    }

    /**
     * @return color of the product
     */
    public String getColor() {
        return color;
    }

    /**
     * @return if the product is a limited edition
     */
    public boolean getIsLimitedEdition() {
        return isLimitedEdition;
    }

    /**
     * @return the price of the object
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return String representation of the Product
     */
    @Override
    public String toString() {
        if (isLimitedEdition) {
            return "Limited edition " + color;
        }

        return color;
    }

    /**
     * @param o Object to be compare product to
     * @return whether or no the passed object is equal to the product
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (((Product) o).getPrice() == price
            && ((Product) o).getIsLimitedEdition() == isLimitedEdition
            && ((Product) o).getColor().equals(color)) {
            return true;
        }
        return false;
    }
}
