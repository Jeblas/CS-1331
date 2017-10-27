/**
 * @author jblasco6
 * @version 1.0
 */
public class Kyliner extends Product {
    /**
     * Constructor
     * @param tColor color of kyliner
     * @param tIsLimited if kyliner is limited edition
     */
    public Kyliner(String tColor, boolean tIsLimited) {
        super(tColor, tIsLimited, 26.0);
    }

    /**
     * @return String representation of the kyler
     */
    @Override
    public String toString() {
        return super.toString() + " Kyliner: $"
            + String.format("%.2f", getPrice());
    }
}
