package Stack;

import java.util.Arrays;

//数组实现栈
public class MyStack_Array<E> {
    private Object[] stack;
    private int size;

    public MyStack_Array() {
        stack = new Object[10];//默认栈大小为10
    }

    /**
     * 判断堆栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) stack[size - 1];
    }

    /**
     * 弹出最后栈顶元素
     *
     * @return
     */
    public E pop() {
        E e = peek();
        stack[size - 1] = null;
        size--;
        return e;
    }

    //压栈
    public E push(E item) {
        ensureCapacity(size + 1);//先检查容量,不够就扩容
        stack[size++] = item;
        return item;
    }

    /**
     * 检查容量 不够扩容
     *
     * @param size
     */
    private void ensureCapacity(int size) {
        int len = stack.length;
        if (len < size) {
            int newlen = 10;//每次容量增加10
            stack = Arrays.copyOf(stack, newlen);//copy旧的元素，并且末尾扩容
        }
    }
}
