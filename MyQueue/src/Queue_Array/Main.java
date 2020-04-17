package Queue_Array;

import QueueInterface.Queue;
import Queue_Array.Impl.ArrayQueueImpl;
import Queue_Array.Impl.LoopQueueImpl;

public class Main {
    public static void main(String[] args) {
        // 动态数组实现的队列
        Queue<Integer> integerQueue1 = new ArrayQueueImpl<>();
        for (int i = 0; i < 15; i++) {
            integerQueue1.enqueue(i);
        }
        while(!integerQueue1.isEmpty()){
            System.out.print(integerQueue1.dequeue()+"  ");
        }
        System.out.println();

        // 动态数组实现的队列
        Queue<Student> studentQueue1 = new ArrayQueueImpl<>();
        for (int i = 0; i < 5; i++) {
            studentQueue1.enqueue(new Student("Tom", 18 + i));
        }
        System.out.println(studentQueue1.getSize());
        while(!studentQueue1.isEmpty()){
            System.out.print(studentQueue1.dequeue()+"  ");
        }
        System.out.println();
        // 循环队列
        Queue<Integer> integerQueue2 = new LoopQueueImpl<>();
        for (int i = 0; i < 15; i++) {
            integerQueue2.enqueue(i);
        }
        System.out.println(integerQueue2.getSize());
        while(!integerQueue2.isEmpty()){
            System.out.print(integerQueue2.dequeue()+"  ");
        }
        System.out.println();
        // 循环队列
        Queue<Student> studentQueue2 = new LoopQueueImpl<>();
        for (int i = 0; i < 5; i++) {
            studentQueue2.enqueue(new Student("Tom", 18 + i));
        }
        System.out.println(studentQueue2.getSize());
        while(!studentQueue2.isEmpty()){
            System.out.print(studentQueue2.dequeue()+"  ");
        }
    }
}
