package Practice.Textbooks;

import java.util.Random;

/**
 * 如何求出数组中第二大的数
 * 普通算法 可以先进行排序在求出第二大的值
 * 如果用快排时间复杂度仍为O(nlogn)
 * 此时可以设计一种算法 扫描一遍数组设置两个变量：
 * 变量a负责存储当前最大数  初始值为array[0]
 * 变量b负责存储第二大数    初始值为最小负整数
 * 如果当前array[i]比a大，则把a赋值给b 即此时b为第二大  再将array[i]赋值给a
 */
public class Algorithm852 {

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


    public static int secondMax(int[] array) {
        int a = array[0];
        int b = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > a) {
                b = a;
                a = array[i];
            }
        }
        return b;
    }


    public static void main(String[] args) {
        Random ra = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = ra.nextInt(100);
        }
        printArray(array);
        System.out.println(secondMax(array));
        System.out.println("--------------------------------------");


    }

}
