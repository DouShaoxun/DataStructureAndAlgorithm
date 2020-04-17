package Practice.Textbooks;

import java.util.*;


/**
 * 找到数组中两数之和相加为SUM的数字组合
 */
public class Algorithm855 {
    private static int begin;//保存最大子数组和的起始位置
    private static int end;//保存最大子数组和的结束位置

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
     * 方法一：暴力 两重循环 时间复杂度O(n²)  不能去重
     *
     * @param array
     * @param SUM
     */
    public static void findSum1(int[] array, int SUM) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == SUM) {
                    System.out.println(array[i] + "+" + array[j] + "=" + SUM);
                }
            }
        }
    }

    /**
     * 方法二：此方法的时间复杂度主要取决于排序的时间复杂度
     * 先排序使用快排或者堆排序 可以将时间复杂度控制到O(nlogn)
     * 然后定义两个指针begin,end分别从前后遍历时间复杂度为O(n)
     * 故整个算法的时间复杂度为O(nlogn)
     * 此方法比双重循环还有一个优点  那就是可以去重
     * @param array
     * @param SUM
     */
    public static void findSum2(int[] array, int SUM) {
        Arrays.sort(array);
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            if (array[begin] + array[end] < SUM) {
                begin++;
            } else if (array[begin] + array[end] > SUM) {
                end--;
            } else {
                System.out.println(array[begin] + "+" + array[end] + "=" + SUM);
                begin++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Random ra = new Random();
        int[] array = new int[15];
        for (int i = 0; i < 15; i++) {
            array[i] = ra.nextInt(20);//为了产生负数 减去70
        }
        printArray(array);
        System.out.println("--------------------------------------------------------------");
        findSum1(array, 20);
        System.out.println("--------------------------------------------------------------");
        findSum2(array, 20);
    }

}
