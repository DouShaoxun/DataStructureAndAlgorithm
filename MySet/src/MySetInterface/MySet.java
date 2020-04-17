package MySetInterface;

public interface MySet<E> {
    /**
     * 向集合中添加元素
     * @param e
     */
    void add(E e);

    /**
     * 删除集合中的元素
     * @param e
     */
    void remove(E e);

    /**
     * 判断集合中是否存在元素e
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 返回集合元素个数
     * @return
     */
    int getSize();

    /**
     * 判断集合是否为空
     * @return
     */
    boolean isEmpty();
}
