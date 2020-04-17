package Practice.Sort;

import java.util.Random;

public class QuickSort {
    /**
     * 快速排序：数组实现
     *
     * @param array
     * @param left
     * @param right
     */
    public static void quickSortArray(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int index = array[i];
        while (i < j) {
            //向左扫描找到比 index小的
            while (i < j && array[j] >= index) {
                j--;
            }
            if (i < j) {
                //如果是因为 a[j] < index跳出上面的循环则应当把a[j]放到index左边
                array[i++] = array[j];
            }
            //向右扫描找到比 index大的
            while (i < j && array[i] < index) {
                i++;
            }
            if (i < j) {
                //如果是因为 a[i] >= index跳出上面的循环则应当把a[i]放到index右边
                array[j--] = array[i];
            }
        }
        //index放到正确的下标上
        array[i] = index;
        //递归
        quickSortArray(array, left, i - 1);
        quickSortArray(array, j + 1, right);

    }

    public static void swapNodeData(Node i, Node j) {
        if (i == null || j == null) {
            return;
        }
        int temp = i.getData();
        i.setData(j.getData());
        j.setData(temp);
    }


    /**
     * 快速排序：单链表实现
     *
     * @param left
     * @param right
     */
    public static void quickSortList(Node left, Node right) {
        /**
         * 设置两个指针 i，j，其中 i 初始时指向数组的第一个元素，j 初始化为 i.next。
         * 然后，我们设定 i 指向的元素为基准数字。
         * key=i
         * 在一趟排序中，把那些比基准数字小的数，移动到前面
         * 如果 j 指向的值大于等于基准数字（如果比基准大，直接跳过）
         * j = j.next
         * 如果 j 指向的值小于基准数字,（如果比基准小，交换 i 和 j 位置上的值）
         * i = i.next
         * swap(i,j)
         * j = j.next
         * j==null的时候 循环结束
         * 再将swap(i,key)
         * 递归继续 递归结束条件：左右指针相等
         */
        if (left == right) {//递归结束条件
            return;
        }
        Node i = left;
        Node j = i.getNext();//j初始值为i下一个结点
        int key = left.getData();//基准数字
        while (j != right) {
            if (j.getData() < key) {
                i = i.getNext();
                swapNodeData(i, j);//交换数据区 不交换指针
            }
            j = j.getNext();
        }
        swapNodeData(left, i);//将基准数字交换到正确的位置
        quickSortList(left, i);//左边 递归
        quickSortList(i.getNext(), right);//右边递归
    }

    public static void main(String[] args) {
        System.out.println("快速排序：数组实现");
        UtilsArray array = new UtilsArray();
        System.out.println("有序:" +array.isOrder());
        quickSortArray(array.getArrray(),0,array.getlength()-1);
        System.out.println("有序:" +array.isOrder());



        System.out.println("快速排序：链表实现");
        UtilsLinkedList list = new UtilsLinkedList();
        System.out.println("有序:" +list.isOrder());
        quickSortList(list.getList().getHead(),null);
        System.out.println("有序:" +list.isOrder());
    }
}