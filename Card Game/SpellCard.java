/**
 * @author jblasco6
 * @version 1.0
 */
public abstract class SpellCard extends Card {

    /**
     * @param tName Name of the SpellCard
     * @param tDescription Description of SpellCard
     */
    public SpellCard(String tName, String tDescription) {
        super(tName, tDescription);
    }

    /**
     * @param ownerField Player's field
     * @param enemyField Player's enemy's field
     */
    abstract void turnEffect(Field ownerField, Field enemyField);

    /**
     * @param ownerField Player's field
     * @param enemyField Player's enemy's field
     */
    abstract void destroyedEffect(Field ownerField, Field enemyField);

    /**
     * @param tCard instance of Object
     * @return if tCard is equal to SpellCard
     */
    @Override
    public boolean equals(Object tCard) {
        if (tCard instanceof SpellCard && super.equals(tCard)) {
            return true;
        }
        return false;
    }
}
