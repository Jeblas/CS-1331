/**
 * @author jblasco6
 * @version 1.0
 */
public class PowerCard extends SpellCard {

    /**
     * Default constructor for PowerCard
     */
    public PowerCard() {
        super("Power Card", "Increases power of monsters by 100 each turn");
    }

    /**
     * All monsters on owners field get +100 power
     * @param ownerField Field of PowerCard owner
     * @param enemyField Field of PowerCard's owner's enemy
     */
    public void turnEffect(Field ownerField, Field enemyField) {
        MonsterCard temp;
        for (int i = 0; i < ownerField.getMonsters().length; i++) {
            temp = ownerField.getMonsters()[i];
            if (temp != null) {
                temp.setPower(temp.getPower() + 100);
            }
        }
    }

    /**
     * When card is destroyed all monsters on owner's field loose 300 power
     * @param ownerField Field of PowerCard owner
     * @param enemyField Field of PowerCard's owner's enemy
     */
    public void destroyedEffect(Field ownerField, Field enemyField) {
        MonsterCard temp;
        for (int i = 0; i < ownerField.getMonsters().length; i++) {
            temp = ownerField.getMonsters()[i];
            if (temp != null) {
                temp.setPower(temp.getPower() - 300);
            }
        }
    }
}
