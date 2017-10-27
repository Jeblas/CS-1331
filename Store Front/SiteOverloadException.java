/**
 * @author jblasco6
 * @version 1.0
 */
public class SiteOverloadException extends Exception {
    /**
     * Defualt constructor
     */
    public SiteOverloadException() {
        super("Site is overloaded.");
    }

    /**
     * Overloaded Constructor
     * @param input message of the exception
     */
    public SiteOverloadException(String input) {
        super(input);
    }

}
