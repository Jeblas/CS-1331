/**
 * @author jblasco6
 * @version 1.0
 */
public abstract class Card {


    private String name;
    private String description;

    /**
     * Get the name of the Card
     * @return Card name
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the Card's name
     * @param tName string to change the name to
     */
    public void setName(String tName) {
        name = tName;
    }

    /**
     * Get the card's description
     * @return string of Card's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Change the card's description
     * @param tDescription string to change description to
     */
    public void setDescription(String tDescription) {
        description = tDescription;
    }

    /**
     *  Constructor for Card
     *  @param tName String to set Card
     *  @param tDescription String to set as description
     */
    public Card(String tName, String tDescription) {
        setName(tName);
        setDescription(tDescription);
    }

    /**
     * Check if parameter is equal to this Card
     * @param c Object to be compared to
     * @return if the object is equal to this Card
     */
    @Override
    public boolean equals(Object c) {
        if (c != null
                && c instanceof Card
                && ((Card) c).getName().equals(this.getName())
                && ((Card) c).getDescription().equals(this.getDescription())) {
            return true;
        }
        return false;
    }

    /**
     * Create a String of Cards information
     * @return String of Card's data
     */
    @Override
    public String toString() {
        return name + ": " + description;
    }

}
