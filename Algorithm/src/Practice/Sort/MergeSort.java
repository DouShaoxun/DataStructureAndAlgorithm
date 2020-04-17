package Practice.Sort;


public class MergeSort {

    /**
     * 归并排序：数组实现
     *
     * @param array
     * @param l
     * @param r
     */
    public static void mergeSortArray(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int Middle = (l + r) / 2;
        // 递归拆分
        mergeSortArray(array, l, Middle);
        mergeSortArray(array, Middle + 1, r);
        // 合并有序数组
        mergeArray(array, l, Middle, r);
    }

    /**
     * 合并有序数组
     *
     * @param array
     * @param l
     * @param Middle
     * @param r
     */

    public static void mergeArray(int[] array, int l, int Middle, int r) {

        int i, j, k;
        int n1 = Middle - l + 1;
        int n2 = r - Middle;
        // 临时数组保存数据
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (i = 0, k = l; i < n1; i++, k++) {
            L[i] = array[k];
        }
        for (i = 0, k = Middle + 1; i < n2; i++, k++) {
            R[i] = array[k];
        }


        // 开始合并
        for (k = l, i = 0, j = 0; i < n1 && j < n2; k++) {
            // 两个有序数组合并成一个有序数组
            if (L[i] > R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
        }
        // 对未合并的数据的处理
        if (i < n1) {
            for (j = i; j < n1; j++, k++) {
                array[k] = L[j];
            }
        }
        if (j < n2) {
            for (i = j; i < n2; i++, k++) {
                array[k] = R[i];
            }
        }
    }



    /**
     * 归并排序：单链表实现
     *
     * @param head
     * @return
     */
    public static Node mergeSortList(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        //得到链表中间的结点   设置 两个指针 快指针一次走两步 满指针一次走一步 当快指针为null的时候 满指针所指向的就是链表的中间结点
        Node middle = getMiddle(head);

        //拆分链表
        Node sHalf = middle.getNext();
        middle.setNext(null);

        // 获得拆分后链表的头   递归调用
        Node aHead = mergeSortList(head);
        Node bHead = mergeSortList(sHalf);

        //返回合并后的 头结点    递归调用
        return merge(aHead, bHead);
    }


    /**
     * 获取中间结点
     *
     * @param head
     * @return
     */
    public static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        //快慢指针
        Node slow, fast;
        slow = fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            // 慢指针一次走一步  快指针一次走两步 快指针为空的的时候 慢指针为中间结点
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;//返回中间结点
    }

    /**
     * 合并两个有序单链表
     *
     * @param aHead  链表a的头结点
     * @param bHead  链表b的头结点
     * @return
     */
    public static Node merge(Node aHead, Node bHead) {
        Node newHead = aHead;
        Node toInsert = bHead;
        while (toInsert != null) {

            Node current = newHead;
            Node last = null;
            //待排序部分的头结点的下一个结点  提前保存next因为后面的操作会改变toInsert.Next
            Node next = toInsert.getNext();

            while (current != null && current.getData() <= toInsert.getData()) {
                // 从头往后找到第一个大于toInsert.data的元素
                last = current;
                current = current.getNext();
            }

            if (last == null) {
                // 如果比任何已排序的数字都要小或者已排序部分还没有结点，那么就成为新的头部
                toInsert.setNext(newHead);
                // 更新已排序的部分的头结点
                newHead = toInsert;
            } else {
                // 否则插入到last的后面  尾插
                toInsert.setNext(last.getNext());
                last.setNext(toInsert);
            }
            // 未排序的结点向后移动
            toInsert = next;
        }
        // 返回合并后的链表的头结点
        return newHead;
    }


    public static void main(String[] args) {
        System.out.println("归并排序：数组实现");
        UtilsArray array = new UtilsArray();
        System.out.println("有序:" + array.isOrder(false));
        mergeSortArray(array.getArrray(), 0, array.getlength() - 1);
        System.out.println("有序:" + array.isOrder(false));


        System.out.println("归并排序：链表实现");
        UtilsLinkedList list = new UtilsLinkedList();
        System.out.println("有序:" + list.isOrder());
        Node newHead = mergeSortList(list.getHead());
        list.setHead(newHead);
        System.out.println("有序:" + list.isOrder());


    }


}
