import java.util.Iterator;

/**
 * @author jblasco6
 * @version 1.0
 * @param <E> generic type to contain
 */
public class MyArrayList<E> implements ArrayListInterface<E> {

    private E[] elements;
    private int numElements;

    private class MyArrayListIterator implements Iterator<E> {
        private int cursor = 0;

        public boolean hasNext() {
            return cursor < numElements;
        }

        public E next() {
            if (!hasNext()) {
                return null;
            }
            E answer = get(cursor++);
            return answer;
        }
    }

    /**
     * iterator constructor
     * @return iterator of type E
     */
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    /**
     * Default constructor
     */
    public MyArrayList() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        numElements = 0;
    }

    /**
     * adds element to list
     * @param e object of type E
     * @throws IllegalArgumentException if e is null
     */
    public void add(E e) throws IllegalArgumentException {
        if (e == null) {
            throw new IllegalArgumentException("Can not add null element.");
        }
        // Resize elements array if needed
        if (numElements >= elements.length) {
            E[] temp = elements;
            elements = (E[]) new Object[(elements.length * 2) + 1];
            for (int i = 0; i < temp.length; i++) {
                elements[i] = temp[i];
            }
        }
        elements[numElements] = e;
        numElements++;
    }

    /**
     * removes all occurances of e
     * @param e object of type E
     * @return object of type E
     * @throws IllegalArgumentException if e is null
     */
    public E removeAll(E e) throws IllegalArgumentException {
        if (e == null) {
            throw new IllegalArgumentException("Can not remove null elements.");
        }

        //int counter = 0;
        //for (E element : elements) {
        for (int i = 0; i < numElements; i++) {
            if ((e.equals(elements[i]))) {
                remove(i);
                i--;
            }
        }
        return e;
    }

    /**
     * remove element at index
     * @param index index of element to remove
     * @return object of type E which was removed
     * @throws IndexOutOfBoundsException if index in not in range
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException();
        }

        E temp = elements[index];
        for (int i = index; i < numElements - 1; i++) {
            elements[i] = elements[i + 1];
        }
        numElements--;
        return temp;
    }

    /**
     * Returns element at index
     * @param index index of item in list
     * @return item at index
     * @throws IndexOutOfBoundsException if index is not in range
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException();
        }

        return elements[index];
    }

    /**
     * clears the array list of all elements
     */
    public void clear() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        numElements = 0;

    }

    /**
     * get the size of the array list
     * @return size of array list
     */
    public int size() {
        return numElements;
    }

    /**
     * detemine if list is empty
     * @return whether the list is empty
     */
    public boolean isEmpty() {
        if (numElements == 0) {
            return true;
        }
        return false;
    }
}
