package Practice.Sort;


public class BubbleSort {

    /**
     * 冒泡排序：数组实现
     *
     * @param array
     */
    public static void bubbleSortArray(int[] array) {
        // 它重复地走访过要排序的元素列，依次比较两个相邻的元素，
        // 如果他们的顺序（如从大到小、首字母从A到Z）错误就把他们交换过来。
        // 走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素列已经排序完成。
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {    //结束 判断  优化
                return;
            }
        }
    }


    /**
     * 冒泡排序：链表实现
     *
     * @param Head
     */
    public static void bubbleSortList(Node Head) {
        if (Head == null || Head.getNext() == null) {
            return;
        }
        Node nodeI = Head;
        while (nodeI != null && nodeI.getNext() != null) {
            //外循环
            Node nodeJ = nodeI;
            boolean flag = false;
            while (nodeJ != null && nodeJ.getNext() != null) {
                //内循环
                if (nodeJ.getData() > nodeJ.getNext().getData()) {//交换数据  只交换结点的数据域
                    int temp = nodeJ.getData();
                    nodeJ.setData(nodeJ.getNext().getData());
                    nodeJ.getNext().setData(temp);
                    flag = true;
                }
                nodeJ = nodeJ.getNext();
            }
            if (!flag) {    //结束 判断
                return;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("冒泡排序：数组实现");
        UtilsArray array = new UtilsArray();
        System.out.println("有序:" + array.isOrder());
        bubbleSortArray(array.getArrray());
        System.out.println("有序:" + array.isOrder());


        System.out.println("冒泡排序：链表实现");
        UtilsLinkedList list = new UtilsLinkedList();
        System.out.println("有序:" +list.isOrder());
        bubbleSortList(list.getList().getHead());
        System.out.println("有序:" +list.isOrder());
    }
}
