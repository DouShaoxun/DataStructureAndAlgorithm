package Queue_Array.Impl;

import QueueInterface.Queue;

/**
 * 动态数组实现
 * @param <E>
 */
public class ArrayQueueImpl<E> implements Queue<E> {
    class Array<E> {
        private E[] data;   //存放数据的数组 泛型
        private int length; //实际长度
        private int size;   //最大长度 不够扩容

        public Array() {
            // java不支持直接new 泛型 可以先new一个Object 然后再转成E[]
            data = (E[]) new Object[10];
            length = 0;
            size = 10;
        }

        public Array(int len) {
            data = (E[]) new Object[len];
            length = 0;
            size = len;
        }

        /**
         * 在数组头部插入数据
         *
         * @param e
         * @return
         */
        public boolean addFirst(E e) {
            if (size == length) {
                resize(2 * size);
            }
            for (int i = length; i >= 0; i--) {
                data[i + 1] = data[i];
            }
            data[0] = e;
            length++;
            return true;
        }

        /**
         * 在数组尾部插入数据
         *
         * @param e
         * @return
         */
        public boolean addLast(E e) {
            if (size <= length) {
                resize(2 * size);
            }
            data[length++] = e;
            return true;
        }

        /**
         * 在指定下标插入
         *
         * @param index
         * @param e
         * @return
         */
        public boolean add(int index, E e) {
            if (index < 0 || index >= length) {
                throw new IllegalArgumentException("add error");
            }
            if (size == length) {
                resize(2 * size);
            }
            //  数组头部
            if (index == 0) {
                addFirst(e);
                return true;
            }
            // 数组当前有效长度
            if (index == length - 1) {
                addLast(e);
                return true;
            }
            for (int i = length; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = e;
            length++;
            return true;
        }

        /**
         * 获取元素
         *
         * @param index
         * @return
         */
        public E get(int index) {
            if (index < 0 || index > length) {
                throw new IllegalArgumentException("get error");
            }
            return data[index];
        }

        /**
         * 修改执行下标的元素
         *
         * @param index
         * @param e
         */
        public void get(int index, E e) {
            if (index < 0 || index > length) {
                throw new IllegalArgumentException("set error");
            }
            data[index] = e;
        }

        /**
         * 根据元素获取下标
         */
        public int find(E e) {
            int index = -1;//失败返回-1
            for (int i = 0; i < length; i++) {
                if (e.equals(data[i])) {
                    index = i;
                }
            }
            return index;
        }

        /**
         * 根据下标删除
         *
         * @param index
         * @return
         */
        public E remove(int index) {
            if (index < 0 || index >= length) {
                throw new IllegalArgumentException("remove error");
            }
            E ret = data[index];
            for (int i = index; i < length; i++) {
                data[i] = data[i + 1];
            }
            length--;
            if ((length <= size / 4) && (size / 2 != 0)) {
                //缩容 节省空间
                resize(size / 2);
            }
            return ret;

        }

        /**
         * 删除第一个
         *
         * @return
         */
        public E removeFirst() {
            return remove(0);
        }

        /**
         * 删除最后一个
         *
         * @return
         */
        public E removeLast() {
            return remove(length - 1);
        }

        /**
         * 删除指定元素
         *
         * @param e
         */
        public void removeElement(E e) {
            int index = find(e);
            if (index != -1) {
                remove(index);
            } else {
                throw new IllegalArgumentException("error");
            }
        }

        /**
         * 扩容
         *
         * @param newsize
         */
        private void resize(int newsize) {
            E[] newData = (E[]) new Object[newsize];
            for (int i = 0; i < length; i++) {
                newData[i] = data[i];
            }
            size = newsize;
            data = newData;
        }

        public int getLength() {
            return length;
        }

        boolean isEmpty() {
            return length == 0;
        }

        public E getFirst() {
            if (isEmpty()) {
                return null;
            }
            return get(0);
        }
    }
    private Array<E> array;

    public ArrayQueueImpl() {
        array=new Array<>();
    }
    public ArrayQueueImpl(int Size) {
        array=new Array<>(Size);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getLength();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
}
