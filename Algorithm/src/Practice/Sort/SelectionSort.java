package Practice.Sort;

import Practice.LinkedList.*;

import java.util.Random;

public class SelectionSort {
    /**
     * 判断是否有序  升序
     *
     * @param array
     * @return
     */
    public static boolean isOrder(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    //用数组实现的选择排序是不稳定的，用链表实现的选择排序是稳定的



    /**
     * 选择排序：数组实现
     *
     * @param array
     */
    public static void selectSortArray(int[] array) {
        //时间复杂度O(n²)
        // 实现：
        // 第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
        // 然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。
        // 以此类推，直到全部待排序的数据元素的个数为零。 选择排序是不稳定的排序方法
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int temp = array[i];    //temp记录未排序数据中当前最小值
            int index = i;       //flag记录未排序数据中最小值的下标
            for (int j = i + 1; j < n; j++) {
                if (array[j] < temp) {
                    temp = array[j];
                    index = j;
                }
            }
            if (index != i) {    //判断是否需要交换
                array[index] = array[i];
                array[i] = temp;
            }
        }
    }

    /**
     * 选择排序链表实现
     *
     * @param Head
     */
    public static void selectSortList(Node Head) {
        if (Head == null || Head.getNext() == null) {
            return;
        }
        Node nodeI = Head;
        while (nodeI != null && nodeI.getNext() != null) {
            Node nodeJ = nodeI.getNext();
            Node temp = nodeI;  //记录当前最元素的指针
            while (nodeJ != null) {
                if (nodeJ.getData() < temp.getData()) {
                    temp = nodeJ;//更新当前最元素的指针
                }
                nodeJ = nodeJ.getNext();
            }
            if (temp != nodeI) {
                //交换
                int tempdata = temp.getData();
                temp.setData(nodeI.getData());
                nodeI.setData(tempdata);
            }
            nodeI = nodeI.getNext();
        }
    }

    public static void main(String[] args) {

        System.out.println("选择排序：数组实现");
        UtilsArray array = new UtilsArray();
        System.out.println("有序:" +array.isOrder());
        selectSortArray(array.getArrray());
        System.out.println("有序:" +array.isOrder());

        System.out.println("选择排序：链表实现");
        UtilsLinkedList list = new UtilsLinkedList();
        System.out.println("有序:" +list.isOrder());
        selectSortList(list.getList().getHead());
        System.out.println("有序:" +list.isOrder());
    }
}
