/**
 * @author jblasco6
 * @version 1.0
 */
public class Field {
    private MonsterCard[] monsters = new MonsterCard[5];
    private SpellCard[] spells = new SpellCard[5];

    /**
     * Getter for monsters
     * @return array of MonsterCards on field
     */
    public MonsterCard[] getMonsters() {
        return monsters;
    }

    /**
     * Getter for spells
     * @return array of SpellCards on field
     */
    public SpellCard[] getSpells() {
        return spells;
    }

    /**
     * Sets MonsterCards' value of canAttack to true
     * Applies SpellCards Effects
     * @param enemyField opponents field object
     */
    public void cardTurnEffects(Field enemyField) {
        for (int i = 0; i < 5; i++) {
            if (spells[i] != null) {
                spells[i].turnEffect(this, enemyField);
            }
        }
        for (int i = 0; i < 5; i++) {
            if (monsters[i] != null) {
                monsters[i].setCanAttack(true);
            }
        }
    }

    /**
     * Adds a monster card to the field
     * @param card MonsterCard Object
     * @return if a MonsterCard could be added to field
     */
    public boolean addMonsterCard(MonsterCard card) {
        for (int i = 0; i < 5; i++) {
            if (monsters[i] == null) {
                monsters[i] = card;
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a SpellCard to the field
     * @param card SpellCard object
     * @return if a SpellCard could be added to field
     */
    public boolean addSpellCard(SpellCard card) {
        for (int i = 0; i < 5; i++) {
            if (spells[i] == null) {
                spells[i] = card;
                return true;
            }
        }
        return false;
    }

}
