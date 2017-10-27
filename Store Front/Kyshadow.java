/**
 * @author jblasco6
 * @version 1.0
 */
public class Kyshadow extends Product {
    /**
     * Constructor
     * @param tColor color of the kyshadow
     * @param tIsLimited if kyshadow is limited
     */
    public Kyshadow(String tColor, boolean tIsLimited) {
        super(tColor, tIsLimited, 42.0);
    }

    /**
     * @return String represenation of kyshadow
     */
    @Override
    public String toString() {
        return super.toString() + " Kyshadow: $"
            + String.format("%.2f", getPrice());
    }
}
