public class ArrayDeque<T> {
    private int size;
    private int head;
    private int tail;
    private T[] array;

    public ArrayDeque() {
        size = 0;
        head = 0;
        tail = 0;
        array = (T[])new Object[8];
    }

    private void resize(int newsize) {
        T[] tmp = (T[])new Object[newsize];
        System.arraycopy(array, head, tmp, 0, size-head);
        System.arraycopy(array, 0, tmp, size-head, head);
        array = tmp;
        head = 0;
        tail = size;
    }

    public void addFirst(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        size += 1;
        head = (head-1) % array.length;
        array[head] = item;
    }

    public void addLast(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        size += 1;
        array[tail] = item;
        tail = (tail+1) % array.length;
    }

    public boolean isEmpty() {
        return size == array.length;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int pointer = head;
        for (int i = 0; i < size; i ++) {
            System.out.print(array[pointer] + " ");
            pointer = (pointer+1) % array.length;
        }
    }

    public T removeFirst() {
        if (size == 0){
            return null;
        }
        T tmp = array[head];
        head = (head+1) % array.length;
        size -= 1;
        return tmp;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }
        tail = (tail-1) % array.length;
        size -= 1;
        return array[tail];
    }

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        int pointer = head;
        pointer = (pointer+index) % array.length;
        return array[pointer];
    }
}