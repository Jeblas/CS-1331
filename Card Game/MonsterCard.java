/**
 * @author jblasco6
 * @version 1.0
 */
public class MonsterCard extends Card {

    private int power;
    private int basePower;
    private boolean canAttack;

    /**
     * Get MonsterCard's power
     * @return MonsterCard Power
     */
    public int getPower() {
        return power;
    }

    /**
     * Set MonsterCard power
     * @param tPower value to be set to power
     */
    public void setPower(int tPower) {
        power = tPower;
    }

    /**
     * Get MonsterCard's starting power
     * @return basePower of MonsterCard
     */
    public int getBasePower() {
        return basePower;
    }

    /**
     * Setter for basePower
     * @param tBasePower value to set basePower to
     */
    public void setBasePower(int tBasePower) {
        basePower = tBasePower;
    }

    /**
     * Getter for canAttack
     * @return value of canAttack
     */
    public boolean getCanAttack() {
        return canAttack;
    }

    /**
     * Setter for canAttack
     * @param tCanAttack value to set canAttack to
     */
    public void setCanAttack(boolean tCanAttack) {
        canAttack = tCanAttack;
    }

    /**
     * MonsterCard Constructor
     * @param tName value to set name tp
     * @param tDescription value to set description to
     * @param tBasePower value to initialize power and basePower to
     * @param tCanAttack value to set canAttack to
     */
    public MonsterCard(String tName, String tDescription,
            int tBasePower, boolean tCanAttack) {
        super(tName, tDescription);
        setPower(tBasePower);
        setBasePower(tBasePower);
        setCanAttack(tCanAttack);
    }

    /**
     * Overloaded MonsterCard Constructor defaults can attack to false
     * @param tName value to set name to
     * @param tDescription value to set description to
     * @param tBasePower value to initialize power and basePower to
     */
    public MonsterCard(String tName, String tDescription, int tBasePower) {
        this(tName, tDescription, tBasePower, false);
    }
    /**
     * MonsterCard specific equals method
     * @param mC Object to compare
     * @return if mC is equal to MonsterCard
     */
    @Override
    public boolean equals(Object mC) {
        if (super.equals(mC)
                && mC instanceof MonsterCard
                && this.getPower() == ((MonsterCard) mC).getPower()
                && this.getBasePower() == ((MonsterCard) mC).getBasePower()
                && this.getCanAttack() == ((MonsterCard) mC).getCanAttack()) {
            return true;
        }
        return false;
    }

    /**
     * Prints MonsterCard values in a String
     * @return Formatted String of MonsterCard variables
     */
    @Override
    public String toString() {
        return super.toString() + " | Power: " + power
            + " | Can attack: " + canAttack;
    }
}
