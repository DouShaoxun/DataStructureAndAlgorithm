package Practice.Linkedlist;

public class Node {


    private Node next;
    private int data;

    public Node(int data) {
        this.next = null;
        this.data = data;
    }

    public Node(Node next, int data) {
        this.next = next;
        this.data = data;
    }

    public Node() {
        this.next = null;
        this.data = 0;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}

