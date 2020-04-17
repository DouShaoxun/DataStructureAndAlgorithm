package Practice.Sort;

import java.util.Random;

public class RadixSort {

    /**
     * 基数排序
     * 基数排序(Radix Sort)是桶排序的扩展，它的基本思想是：将整数按位数切割成不同的数字，然后按每个位数分别比较。
     * 排序过程：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
     * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
     * <p>
     * 算法描述
     * 取得数组中的最大数，并取得位数；
     * arr为原始数组，从最低位开始取每个位组成radix数组；
     * 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     */
    public static int radix = 10;//基数 取10  十进制


    public static void radixSortArray(int[] array) {
        // 数组的第一维表示可能的余数0-radix，第二维表示array中的等于该余数的元素
        // 如：十进制123的个位为3，则bucket[3][] = {123}
        int[][] bucket = new int[radix][array.length];
        int distance = getDistance(array); // distance表示最大的数有多少位
        int temp = 1;
        int round = 1; // 控制 键值排序依据 哪一位上的数字 1的时候 根据各位排序，2的时候根据十位
        while (round <= distance) {
            // 用来计数：数组counter[i]用来表示该位是i的数的个数
            int[] counter = new int[radix];
            // 将array中元素分布填充到bucket中，并进行计数
            for (int i = 0; i < array.length; i++) {
                //temp从1到10，再到100   which表示i在此次排序中  应该在哪个桶里
                // (array[i] / temp) % radix 可以拿出第round位上的数字存到which中，round为1时表示个位，2表示十位
                int which = (array[i] / temp) % radix;
                //放在对应的桶中
                bucket[which][counter[which]] = array[i];
                //当前位上的数字个数+1
                counter[which]++;
            }
            int index = 0;
            // 根据bucket中收集到的array中的元素，根据统计计数，在array中重新排列
            for (int i = 0; i < radix; i++) {
                if (counter[i] != 0)
                    for (int j = 0; j < counter[i]; j++) {
                        array[index++] = bucket[i][j];
                    }
                counter[i] = 0;
            }
            temp *= radix;
            round++;
        }
    }

    /**
     * 求数组当中最大值的位数
     *
     * @param array
     * @return
     */
    public static int getDistance(int[] array) {
        int max = computeMax(array);//数组中的最大值
        int digits = 0;//最大值的位数
        int temp = max / radix;
        while (temp != 0) {
            digits++;
            temp = temp / radix;
        }
        return digits + 1;
    }

    /**
     * 求数组最大值
     *
     * @param array
     * @return
     */
    public static int computeMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println("基数排序：数组实现");
        UtilsArray array = new UtilsArray();
        System.out.println("有序:" + array.isOrder());
        radixSortArray(array.getArrray());
        System.out.println("有序:" + array.isOrder());
    }
}
