package Queue;

public class MyQueue_Linklist<E> {
    private Node<E> head = null;
    private Node<E> tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void put(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null && tail == null) {
            //队列为空
            head = tail = newNode;
        } else {
            //采用尾插
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E pop() {
        if (this.isEmpty()) {
            return null;
        }
        E data = head.data;
        head = head.next;//后移  同时jvm会删除head之前指向的结点
        return data;
    }

    public int size() {
        Node<E> tmp = head;
        int n = 0;
        while (tmp != null) {
            n++;
            tmp = tmp.next;
        }
        return n;
    }
}
