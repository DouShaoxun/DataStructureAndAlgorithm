package Stack;


//链表实现栈
public class MyStack_Linklist<E> {
    Node<E> top = null;

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 压栈
     *
     * @param data
     */
    public void push(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = top;//头插
        top = newNode;
    }

    /**
     * 出栈
     *
     * @return
     */
    public E pop() {
        if (this.isEmpty()) {
            return null;
        }
        E data = top.data;
        top = top.next;//删除头结点
        return data;
    }

    /**
     * 返回栈顶元素值
     *
     * @return
     */
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return top.data;
    }
}
