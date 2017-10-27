/**
 * @author jblasco6
 * @version 1.0
 */
public class BlueEyesWhiteDragon extends MonsterCard implements Special {

    /**
     * Default constructor for BlueEyesWhiteDragon
     */
    public BlueEyesWhiteDragon() {
        super("Blue Eyes White Dragon", "The best card.", 3000, true);
    }

    /**
     * Adds up to two more BLEWs to the field if room
     * @param owner Field of the card's owner
     * @param enemy Field of the enemy of the card's owner
     */
    public void instantEffect(Field owner, Field enemy) {
        owner.addMonsterCard(new BlueEyesWhiteDragon());
        owner.addMonsterCard(new BlueEyesWhiteDragon());
    }
}
