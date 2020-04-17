package Practice.Textbooks;

import java.util.Arrays;
import java.util.Random;


/**
 * 如何找出数组中第k小的数字
 */
public class Algorithm857 {

    /**
     * 打印数组
     *
     * @param array
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%4d", array[i]);
        }
        System.out.println();
    }

    /**
     * 方法一：先排序
     *
     * @param array
     * @param k
     * @return
     */
    public static int findKNum1(int[] array, int k) {
        if (k > array.length || array == null) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(array);
        return array[k - 1];
    }

    /**
     * 方法二："剪枝"法
     * 采用快速排序的思想
     *
     * @param array
     * @param k
     * @return
     */
    public static int findKNum2QuikSort(int[] array, int low, int high, int k) {
        int i, j, temp;
        if (low > high) {
            return Integer.MIN_VALUE;
        }
        i = low + 1;
        j = high;
        temp = array[low];
        while (i < j) {
            while (i < j && array[j] >= temp) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }

            while (i < j && array[i] < temp) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = temp;
        if (i + 1 == k) {
            return temp;
        } else if (i + 1 > k) {
            return findKNum2QuikSort(array, low, i - 1, k);
        } else {
            return findKNum2QuikSort(array, j + 1, high, k);
        }
    }

    public static int findKNum2(int[] array, int k) {
        if (k > array.length || array == null) {
            return Integer.MIN_VALUE;
        }
        return findKNum2QuikSort(array, 0, array.length - 1, k);
    }

    public static void main(String[] args) {
        Random ra = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = ra.nextInt(100) ;
        }
        printArray(array);
        System.out.println(findKNum2(array, 4));
        System.out.println("--------------------------------------------------------------");
        System.out.println(findKNum1(array, 4));
        printArray(array);


    }

}
