package StackInterface;

public interface Stack<E> {
    /**
     * 入栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 返回栈顶元素
     * @return
     */
    E peek();

    /**
     * 返回栈大小
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();
}
