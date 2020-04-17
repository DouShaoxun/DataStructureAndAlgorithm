package Queue;

import Stack.MyStack_Linklist;
import org.junit.Test;

public class test {
    @Test
    public void testMyQueue_Linklist() {
        MyQueue_Linklist<Integer> q = new MyQueue_Linklist<>();
        q.put(1);
        q.put(-10);
        q.put(5);
        int len = q.size();
        for (int i = 0; i < len; i++) {
            System.out.println(q.pop());
        }
    }

    @Test
    public void testtestMyQueue_Array() {
        MyQueue_Array<Integer> q = new MyQueue_Array<>();
        q.put(10);
        q.put(1);
        q.put(6);
        int len = q.size();
        for (int i = 0; i < len; i++) {
            System.out.println(q.pop());
        }
    }
}
