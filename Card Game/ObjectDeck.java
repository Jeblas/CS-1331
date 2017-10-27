/**
 * @author jblasco6
 * @version 1.0
 */
public abstract class ObjectDeck {
    private Object[] arr;

    /**
     * Constructor for ObjectDeck
     * @param inArr Array of objects to store into arr
     */
    public ObjectDeck(Object...inArr) {
        arr = inArr;
    }

    /**
     * Deal a single card from the ObjectDeck
     * @return highest non null object in arr
     */
    public Object deal() {
        Object temp;
        for (int i = arr.length - 1; i >= 0; --i) {
            if (arr[i] != null) {
                temp = arr[i];
                arr[i] = null;
                return temp;
            }
        }
        return null;
    }

    /**
     * Get the number of non null elements in arr
     * @return number of non-null elements in arr
     */
    public int size() {
        int count = 0;
        for (Object obj : arr) {
            if (obj != null) {
                ++count;
            }
        }
        return count;
    }

    /**
     * Check is arr is empty
     * @return if arr has a size of 0
     */
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }
}
