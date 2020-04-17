package Queue;

import java.util.LinkedList;

public class MyQueue_Array<E> {
    private LinkedList<E> list = new LinkedList<>();
    private int size = 0;

    public synchronized void put(E e) {
        list.add(e);
        size++;
    }

    public synchronized E pop() {
        size--;
        return list.removeFirst();//返回第一个元素 并删除
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized int size() {
        return size;
    }

}
