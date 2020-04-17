package Stack;

import org.junit.Test;

public class test {
    @Test
    public void testMyStack_Array() {
        MyStack_Array<Integer> s = new MyStack_Array<>();
        for (int i = 1; i < 5; i++) {
            s.push(i * 10);
        }
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.peek());

    }

    @Test
    public void testMyStack_Linklist() {
        MyStack_Linklist<Integer> s = new MyStack_Linklist<>();
        for (int i = 1; i < 5; i++) {
            s.push(i * 10);
        }
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.peek());
    }

    @Test
    public void testMinStack() {
        MinStack s = new MinStack();
        s.push(10);
        s.push(8);
        s.push(1);
        s.push(7);
        s.push(6);
        System.out.println(s.min());

    }
}
