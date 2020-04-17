package Practice.Sort;

public class HeapSort {

    /**
     * 交换数组中的值
     *
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * 堆排序：调整堆
     *
     * @param a
     * @param pos
     * @param len
     */
    public static void adjustMinHeap(int[] a, int pos, int len) {

        int temp = a[pos];//temp保存当前元素

        while (2 * pos + 1 <= len) {

            // 从pos结点的左子结点开始，也就是2*pos+1处开始(数组下标从0开始)
            // child先指向左孩子
            int child = 2 * pos + 1;

            //child + 1是右孩子   确保有右孩子的情况下 判断右孩子是否比左孩子还要小
            if (child + 1 <= len && a[child] > a[child + 1]) {
                child++;//child指向右孩子
            }
            if (a[child] < temp) {      //如果孩子的最小值比父节点还小 则更新父节点
                a[pos] = a[child];
            } else {        // 反之跳出循环 因为下面的结点肯定都比孩子的结点还要大
                break;
            }
            pos = child; //更新父节点
        }
        a[pos] = temp;//将temp值放到最终的位置
    }

    /**
     * 小顶堆：降序
     *
     * @param a
     */
    public static void MinHeapSort(int[] a) {
        int len = a.length;
        //1.构建小顶堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            //初始化堆
            adjustMinHeap(a, i, len - 1);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int i = len - 1; i >= 0; i--) {
            //将堆顶元素与末尾元素进行交换
            swap(a, 0, i);
            //调整堆
            adjustMinHeap(a, 0, i - 1);
        }
    }


    /**
     * 大顶堆：升序
     *
     * @param
     */
    public static void MaxHeapsort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //i从arr.length / 2 - 1开始保证i有孩子结点
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustMaxHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素(无序序列最大元素)与末尾元素进行交换
            adjustMaxHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustMaxHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //从i结点的左子结点开始，也就是2i+1处开始
            // 数组下标从0开始所以左子树2*i+1
            // k = k * 2 + 1 是对子树进行 堆调整
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {
                //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }


    public static void main(String[] args) {
        System.out.println("堆排序：小顶堆");
        UtilsArray array = new UtilsArray();
        System.out.println("有序:" + array.isOrder(false));
        MinHeapSort(array.getArrray());
        System.out.println("有序:" + array.isOrder(false));


        System.out.println("堆排序：大顶堆");
        array = new UtilsArray();
        System.out.println("有序:" + array.isOrder());
        MaxHeapsort(array.getArrray());//大顶堆
        System.out.println("有序:" + array.isOrder());
    }

}

