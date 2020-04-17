package Set_BST;

import MySetInterface.MySet;

/**
 * 基于二叉搜索树实现集合
 *
 * @param <E>
 */
public class Set_BST<E extends Comparable<E>> implements MySet<E> {
    private BST<E> bst;//二叉树  此二叉树不支持重复数据插入

    public Set_BST() {
        this.bst = new BST<E>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
