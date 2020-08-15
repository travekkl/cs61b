public class ArrayDeque < T > {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int arrayLen;
    private float refactor;

    public ArrayDeque() {
        refactor = (float) 0.25;
        arrayLen = 8;
        items = (T[]) new Object[arrayLen];
        nextFirst = arrayLen - 1;
        nextLast = 0;
        size = 0;
    }

    /** Resize the array deque*/
    private void resizeArray() {
        if ((arrayLen >= 16) && (size < arrayLen * refactor))
        {
            arrayLen = Math.round((int) (1 + refactor) * size);
        } else if (size + 1 > arrayLen) {
            if (arrayLen < 16) {
                arrayLen = 16;
            } else {
                arrayLen = Math.round((1 + refactor) * size);
            }
        } else {
            return;
        }

        T[] tempArray = (T[]) new Object[arrayLen];
        System.arraycopy(items, 0, tempArray, 0, Math.min(arrayLen, size));
        items = tempArray;
        tempArray = null;

    }

    /** Adds an item of type T to the front of the deque*/
    public void addFirst(T item) {
        resizeArray();
        items[nextFirst] = item;
        size++;
        nextFirst--;
        if (nextFirst < 0) {
            nextFirst = arrayLen - 1;
        }
    }

    /** Adds an item of type T to the back of the deque*/
    public void addLast(T item) {
        resizeArray();
        items[nextLast] = item;
        size++;
        nextLast++;
        if (nextLast >= arrayLen) {
            nextLast = 0;
        }
    }

    /** Returns true if deque is empty, false otherwise*/
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Returns the number of items in the deque*/
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space*/
    public void printDeque() {
        if (!isEmpty()) {
            int index = (nextFirst + 1) % arrayLen;
            while (index != nextLast) {
                System.out.print(items[index]);
                System.out.print(' ');
                index = (index + 1) % arrayLen;
            }
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque*/
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        nextFirst = (nextFirst + 1) % arrayLen;
        size--;
        resizeArray();
        return items[nextFirst];
    }

    /** Removes and returns the item at the back of the deque*/
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        nextLast = (nextLast + arrayLen - 1) % arrayLen;
        size--;
        resizeArray();
        return items[nextLast];
    }

    /** Gets the item at the given index*/
    public  T get(int index) {
        return items[(nextFirst + 1 + index) % arrayLen];
    }

}
