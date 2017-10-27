/**
 * Interface which MyArrayList should implement
 * @author Isabella Plonk
 * @version 1.0
 * @param <E> the type of the data of the array list
 */
public interface ArrayListInterface<E> extends Iterable<E> {

    /**
     * The initial capacity of the array list
     */
    int INITIAL_CAPACITY = 10;

    /**
     * Adds the element to the last position in the array list
     * Throws an IllegalArgumentException if element is null
     * @param e the element to be added to the array list
     */
    void add(E e);

    /**
     * Removes all instance of the passed in element from the
     * array list then returns the element that was removed
     * or null if the element was not contained in the array list
     * @throws IllegalArgumentException if element is null
     * @param e the element to be removed
     * @return E the element removed
     */
    E removeAll(E e);


    /**
     * Removes the element at the passed in index from the
     * array list then returns the element that was removed
     * or null if the element was not contained in the array list
     * @throws IndexOutOfBoundsException if index is less than
     * zero or greater than or equaled to the number of elements
     * in the array list
     * @param index the index of the element to be removed
     * @return the element that was removed
     */
    E remove(int index);

    /**
     * Returns the element at the passed in index of the array list
     * Does not remove the element from the array list
     * @throws IndexOutOfBoundsException if index is less
     * than zero or greater than or equaled to the number of
     * elements in the array list
     * @param index the index of the element in the array list
     * @return the element at the given index in the array list
     */
    E get(int index);

    /**
     * Removes all elements from array list and sets array list
     * back to original capacity
     */
    void clear();

    /**
     * Returns the number of elements contained in the array list
     * @return int the number of elements in the array list
     */
    int size();

    /**
     * Returns false if the array list contains one or more elements
     * and returns true if the array list contains no elements
     * @return boolean whether the array list contains any elements
     */
    boolean isEmpty();

}
