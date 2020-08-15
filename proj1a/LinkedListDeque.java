/** Linked List Deque*/
public class LinkedListDeque<T> {
    /** Create class IntNode as a helper, it is a LinkedList*/
    private class IntNode {
        private IntNode pre;
        private T item;
        private IntNode next;
        /** Constructor*/
        public IntNode(IntNode p, T i, IntNode n) {
            pre = p;
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /** Constructor without para*/
    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }
    /** Adds an item of type T to the front of the deque*/
    public void addFirst(T item) {
        if (isEmpty()) {
            sentinel.next = new IntNode(sentinel, item, sentinel);
            sentinel.pre = sentinel.next;
        } else {
            sentinel.next = new IntNode(sentinel, item, sentinel.next);
            sentinel.next.next.pre = sentinel.next;
        }
        size++;
    }
    /** Adds an item of type T to the back of the deque*/
    public void addLast(T item) {
        if (isEmpty()) {
            sentinel.next = new IntNode(sentinel, item, sentinel);
            sentinel.pre = sentinel.next;
        } else {
            sentinel.pre = new IntNode(sentinel.pre, item, sentinel);
            sentinel.pre.pre.next = sentinel.pre;
        }
        size++;
    }
    /** Returns true if deque is empty, false otherwise*/
    public boolean isEmpty () {
        if (size == 0) {
            return true;
        }
        return false;
    }
    /** Returns the number of items in the deque*/
    public int size() {
        return size;
    }
    /** Prints the items in the deque from first to last,
     * separated by a space*/
    public void printDeque() {
        if (!isEmpty()) {
            IntNode L = sentinel.next;
            while (L.next != sentinel) {
                System.out.print(L.item);
                System.out.print(' ');
                L = L.next;
            }
            System.out.println(L.item);
        }
    }
    /** Removes and returns the item at the front of the deque,
     * if no such item exists, returns null*/
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T L = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size--;
        return L;
    }
    /** Removes and returns the item at the back of the deque. if
     * no such item exists, returns null*/
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T L = sentinel.pre.item;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.next = sentinel;
        size--;
        return L;
    }
    /** Gets the item at the given index*/
    public T get(int index) {
        if ((isEmpty()) || (index + 1 > size)) {
            return null;
        }
        IntNode L = sentinel.next;
        int cnt = index;
        while (cnt > 0) {
            L = L.next;
            cnt--;
        }
        return L.item;
    }
    /** the helper of the Method get*/
    private  T getHelper(int index, IntNode L) {
        if (index == 0) {
            return L.item;
        }

        return getHelper(index - 1, L.next);
    }
    /**another get method use recursive*/
    public T getRecursive(int index) {
        if ((isEmpty()) || (index + 1 > size)) {
            return null;
        }
        return getHelper(index, sentinel.next);
    }
}
