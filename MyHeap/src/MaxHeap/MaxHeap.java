package MaxHeap;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {

        data = new Array<E>(capacity);
    }

    public MaxHeap() {
        data = new Array<E>();
    }

    /**
     * 将一个数组  转换为大顶堆 时间复杂度O(n)
     * @param arr
     */
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        // 从最后一个非叶子结点 开始下沉
        for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
            siftDown(i);
    }
    /**
     * 返回堆中的元素个数
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 返回一个布尔值, 表示堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 重新调整堆 尾部元素上浮
     *
     * @param k
     */
    private void siftUp(int k) {
        //没有到达根节点 且 当前k结点 比其父结点的值小
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(parent(k), k);
            k = parent(k);//继续往上走
        }
    }

    /**
     * 获取最大值
     *
     * @return
     */
    public E findMax() {
        if (data.isEmpty()) {
            throw new RuntimeException("error");
        }
        return data.get(0);
    }

    /**
     * 取出最大值
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        // 先和最后一个元素交换位置 在删除 降低时间复杂度
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 重新调整堆 从顶部开始下沉
     *
     * @param k
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (rightChild(k) < data.getSize()) {   // 假如有右孩子
                if (data.get(rightChild(k)).compareTo(data.get(j)) > 0) { // 右孩子大于左孩子
                    j++;
                }
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {// k比两个孩子的最大值还大 就不用交换了
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     * @param e
     * @return
     */
    public E replace(E e){

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + data +
                '}';
    }
}
