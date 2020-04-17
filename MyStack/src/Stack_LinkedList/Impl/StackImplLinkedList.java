package Stack_LinkedList.Impl;

import StackInterface.Stack;

/**
 * 单链表实现栈
 * @param <E>
 */
public class StackImplLinkedList<E> implements Stack<E> {
    /**
     * 链表内部类
     * @param <E>
     */
    public class MyLinkedList<E> {
        /**
         * 内部节点类
         */
        private class Node {
            public E e;
            public Node next;

            public Node() {
                this(null);
            }

            public Node(E e) {
                this(e, null);// 调用其他构造方法
            }

            public Node(E e, Node next) {
                this.e = e;
                this.next = next;
            }

            @Override
            public String toString() {
                return e.toString();//调用数据自己的toString
            }
        }


        private Node dummyHead;
        private int size;

        public MyLinkedList() {
            dummyHead = new Node(null, null);
            size = 0;
        }

        /**
         * 获取 大小
         *
         * @return
         */
        public int getSize() {
            return size;
        }

        /**
         * 判断链表是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }


        /**
         * 指定位置插入
         *
         * @param index
         * @param e
         */
        public void add(int index, E e) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add error!");
            }
            Node prevNode = dummyHead;
            for (int i = 1; i <= index; i++) {
                prevNode = prevNode.next;
            }
            if (prevNode != null) {
                prevNode.next = new Node(e, prevNode.next);
                size++;
            }
        }

        /**
         * 链表头部插入元素e
         */
        public void addFirst(E e) {
            add(0, e);
        }

        /**
         * 尾部插入元素
         *
         * @param e
         */
        public void addLast(E e) {
            add(size, e);
        }

        /**
         * 获取指定下标上的元素
         *
         * @param index
         * @return
         */
        public E get(int index) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add error!");
            }
            Node cur = dummyHead.next;
            for (int i = 1; i <= index; i++) {
                cur = cur.next;
            }
            return cur.e;
        }

        /**
         * 获取第一个元素
         *
         * @return
         */
        public E getFirst() {
            return get(0);
        }

        /**
         * 获取最后一个元素
         *
         * @return
         */
        public E getLast() {
            return get(size - 1);
        }

        /**
         * 更新指定 下标上的元素
         *
         * @param index
         * @param e
         */
        public void set(int index, E e) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add error!");
            }
            Node cur = dummyHead.next;
            for (int i = 1; i <= index; i++) {
                cur = cur.next;
            }
            cur.e = e;
        }

        /**
         * 判断链表是否含有e元素
         *
         * @param e
         * @return
         */
        public boolean contains(E e) {
            Node cur = dummyHead.next;
            while (cur != null) {
                if (e == cur.e) {
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Node cur = dummyHead.next;
            while (cur != null) {
                stringBuilder.append(cur + " -> ");
                cur = cur.next;
            }
            stringBuilder.append("null");
            return stringBuilder.toString();
        }


        /**
         * 删除指定下标上的元素
         *
         * @param index
         */
        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Add error!");
            }
            Node prevNode = dummyHead;
            for (int i = 0; i < index; i++) {
                prevNode = prevNode.next;
            }
            Node retNode = prevNode.next;
            prevNode.next = retNode.next;
            retNode.next = null;
            size--;
            return retNode.e;
        }

        /**
         * 删除第一个元素
         */
        public E removeFirst() {
            return remove(0);
        }

        /**
         * 删除最后一个元素
         */
        public E removeLast() {
            return remove(size-1);
        }

    }

    private MyLinkedList<E> list;

    public StackImplLinkedList() {
        list = new MyLinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
