package Queue_LinkedList;


import QueueInterface.Queue;
import Queue_LinkedList.Impl.QueueImplLinkedList;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> integerQueue = new QueueImplLinkedList<>();

        for (int i = 0; i < 5; i++) {
            integerQueue.enqueue(i);
        }
        while (!integerQueue.isEmpty()) {
            System.out.println(integerQueue.dequeue());
        }
    }
}
