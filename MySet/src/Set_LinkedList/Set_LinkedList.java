package Set_LinkedList;

import MySetInterface.MySet;

/**
 * 链表实现 集合
 *
 * @param <E>
 */
public class Set_LinkedList<E> implements MySet<E> {
    private MyLinkedList<E> linkedList;

    public Set_LinkedList() {
        this.linkedList = new MyLinkedList<E>();
    }

    @Override
    public void add(E e) {
        if(contains(e)){// 如果list中含有e 则不添加
            return;
        }
        linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
