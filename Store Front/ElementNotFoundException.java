/**
 * ElementNotFoundException gets thrown when an element does not exist
 *
 * @author Isabella Plonk
 * @version 1.0
 */
public class ElementNotFoundException extends Exception {

    private Object object;

    /**
     * Creates a new ElementNotFoundException with the given message
     * @param object the object that caused this exception
     * @param msg the message of the exception
     */
    public ElementNotFoundException(Object object, String msg) {
        super(msg);
        this.object = object;
    }

    /**
     * Getter method for object
     * @return the object that caused this exception
     */
    public Object getObject() {
        return object;
    }
}
