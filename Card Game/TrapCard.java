/**
 * @author jblasco6
 * @version 1.0
 */
public abstract class TrapCard extends Card implements Special {

    /**
     * @param tName Name of TrapCard
     * @param tDescription Description of TrapCard
     */
    public TrapCard(String tName, String tDescription) {
        super(tName, tDescription);
    }
    /**
     * @param owner Field of player who owns card
     * @param enemy Field of the opponent
     */
    public abstract void instantEffect(Field owner, Field enemy);

    /**
     * @param tCard TrapCard object to be compared
     * @return whether tCard is equal to the current card
     */
    @Override
    public boolean equals(Object tCard) {
        if (tCard instanceof TrapCard && super.equals(tCard)) {
            return true;
        }
        return false;
    }
}
