/**
 * @author jblasco6
 * @version 1.0
 */
public class LipKit extends Product {
    /**
     * Constructor
     * @param tColor color of the lipkit
     * @param tIsLimited if the kipkit is limited edition
     */
    public LipKit(String tColor, boolean tIsLimited) {
        super(tColor, tIsLimited, 29.0);
    }

    /**
     *
     * @return string representation of the lipkip
     */
    @Override
    public String toString() {
        return super.toString() + " LipKit: $"
            + String.format("%.2f", getPrice());
    }
}
