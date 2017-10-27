/**
 * @author jblasco6
 * @version 1.0
 */
public interface Special {
    /**
     * InstantEffect for objects implementing Special
     * @param owner field of the Special's owner
     * @param enemy field of the Special's enemy
     */
    void instantEffect(Field owner, Field enemy);
}
