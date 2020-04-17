package Practice.Sort;


public class InsertSort {

    /**
     * 插入排序：数组实现
     *
     * @param array
     */
    public static void insertSortArray(int[] array) {
        //是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int temp = array[i];//保存临时数据
            int j = i;
            if (array[j - 1] > temp) {
                // 插入排序这里采用while或者for 都要把j定义在外面 为了执行最后一步 array[j] = temp;
                while (j > 0 && array[j - 1] > temp) {//找到不大于temp元素的位置进行插入
                    array[j] = array[j - 1];    //元素向后移动
                    j--;
                }
            }
            array[j] = temp;    //插入
        }
    }


    /**
     * 插入排序：链表实现
     *
     * @param Head
     */
    public static Node insertSortList(Node Head) {
        /*
         *
         * 这个算法的思想是这样的：
         *    1. 在原链表上维护两部分,一是已排序的部分,一是待排序的部分
         *    2. 刚开始的时候,已排序部分为null
         *    3. 每次取出待排序部分的第一个元素A,和已排序的部分逐个比较（从头往后或从后往前都可以
         *       不过单链表只能够从头往后比较）,找到第一个大于A的元素B
         *    4. 将A插在B的前面一个位置（如果B原来是链表头，那么A将变成新的链表头,此时要记得更新链表头指针）
         *    5. 排序结束后,让新的头结点返回,或者设置链表对象新的头结点
         * */
        // 注意这样写，是不需要额外判断Head是否为null的
        Node newHead = null;                    //已排序的部分的头结点
        Node toInsert = Head;         //待排序部分的头结点
        while (toInsert != null) {
            //直到遍历所有待排序的结点 算法结束

            Node current = newHead,             //current 临时保存已排序的部分的头结点
                    last = null,                // 用于临时保存current
                    next = toInsert.getNext();  //待排序部分的头结点的下一个结点  提前保存next因为后面的操作会改变toInsert.Next

            while (current != null && current.getData() <= toInsert.getData()) {
                // 从头往后找到第一个大于toInsert.data的元素
                last = current;
                current = current.getNext();
            }

            if (last == null) {
                // 如果比任何已排序的数字都要小或者已排序部分还没有结点，那么就成为新的头部
                toInsert.setNext(newHead);
                newHead = toInsert;//更新已排序的部分的头结点
            } else {
                // 否则插入到last的后面  尾插
                toInsert.setNext(last.getNext());
                last.setNext(toInsert);
            }
            //  未排序的结点向后移动
            toInsert = next;
        }
        return newHead;
    }


    /**
     * 将两个有序链表合并成一个有序链表
     *
     * @param Head2
     * @return
     */
    public static Node MergeSortList(Node Head1, Node Head2) {

        Node newHead = Head1;
        Node toInsert = Head2;
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
                newHead = toInsert;//更新已排序的部分的头结点
            } else {
                // 否则插入到last的后面  尾插
                toInsert.setNext(last.getNext());
                last.setNext(toInsert);
            }
            //  未排序的结点向后移动
            toInsert = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println("插入排序：数组实现");
        UtilsArray array = new UtilsArray();
        System.out.println("有序:" +array.isOrder());
        insertSortArray(array.getArrray());
        System.out.println("有序:" +array.isOrder());


        System.out.println("插入排序：链表实现");
        UtilsLinkedList list = new UtilsLinkedList();
        System.out.println("有序:" +list.isOrder());
        Node newHead = insertSortList(list.getHead());
        list.setHead(newHead);
        System.out.println("有序:" +list.isOrder());

        System.out.println("两条有序链表合并");
        UtilsLinkedList l1 = new UtilsLinkedList();
        UtilsLinkedList l2 = new UtilsLinkedList();
//        System.out.println(l1.isOrder());
//        System.out.println(l2.isOrder());
        newHead = insertSortList(l1.getHead());
        l1.setHead(newHead);
        newHead = insertSortList(l2.getHead());
        l2.setHead(newHead);
//        System.out.println(l1.isOrder());
//        System.out.println(l2.isOrder());
        newHead = MergeSortList(l1.getHead(),l2.getHead());
        l1.setHead(newHead);//将合并后的链表用l1保存
        System.out.println("合并结果:" +l1.isOrder());
    }
}
