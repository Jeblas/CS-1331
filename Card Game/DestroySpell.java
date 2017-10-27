/**
 * @author jblasco6
 * @version 1.0
 */
public class DestroySpell extends TrapCard {

    /**
     * Default constructor for DestroySpell
     */
    public DestroySpell() {
        super("Destroy Spell", "Destroys the enemy's first spell card");
    }

    /**
     * Remove the first spell from the enemy's field
     * @param owner Field of the owner of Destroy spell
     * @param enemy Enemy's field
     */
    public void instantEffect(Field owner, Field enemy) {
        for (int i = 0; i < enemy.getSpells().length; i++) {
            if (enemy.getSpells()[i] != null) {
                enemy.getSpells()[i].destroyedEffect(enemy, owner);
                enemy.getSpells()[i] = null;
                break;
            }
        }
    }

}
