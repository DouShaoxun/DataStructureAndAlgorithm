package Practice.Sort;

import Practice.LinkedList.LinkedList;

import java.util.Random;

public class ShellSort {
    /**
     * 希尔排序：数组实现
     *
     * @param array
     */
    public static void shellSort(int[] array) {
        // 希尔排序是插入排序的一种又称“缩小增量排序”
        // 是直接插入排序算法的一种更高效的改进版本
        int length = array.length;
        for (int h = length / 2; h > 0; h /= 2) {   // h表示步长，且步长逐渐缩小
            for (int i = h; i < length; i++) {      // 划分子序列
                int V = array[i];
                int j = i;
                // 寻找插入点
                // while (j > 0 && array[j - h] > temp && (j - h) >= 0) 仍会越界 因为先判断了array[j - h] > temp
                // while (j > 0 && (j - h) >= 0 && array[j - h] > temp) 没有问题
                while (j > 0 && array[j - h] > V) {
                    array[j] = array[j - h];
                    j -= h;
                    if (j - h < 0) {   //一定要判断j-h是否大于等于0  否则数组会越界
                        break;
                    }
                }
                array[j] = V;    //插入
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("希尔排序：数组实现");
        UtilsArray array = new UtilsArray();
        System.out.println("有序:" + array.isOrder());
        shellSort(array.getArrray());
        System.out.println("有序:" + array.isOrder());
    }
}
