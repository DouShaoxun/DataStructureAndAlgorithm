package Practice.Textbooks;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 如何求数对之差的最大值
 * 问题描述：数组中的一个数字减去它右边子数组中的一个数字可以得到一个差，求所有可能的最大差值
 */
public class Algorithm8511 {
    /**
     * 方法一：暴力法 时间复杂度O(n²)
     * 双重循环找出所有可能的差值 记录最大的差值
     *
     * @param array
     * @return
     */
    public static int getMaxSub1(int[] array) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] - array[j] > result) {
                    result = array[i] - array[j];
                }
            }
        }
        return result;
    }

    /**
     * 方法二：二分法
     * 将数组分成左右两部分
     * 则最大差值有三种情况：
     * 1.最大差值在左子数组中
     * 2.最大差值在右子数组中
     * 3.最大差值是左子数组的最大值减去右子数组的最小值
     *
     * @param array
     * @return
     */
    public static int getMaxSub2(int[] array) {
        AtomicInteger max = new AtomicInteger(0);
        AtomicInteger min = new AtomicInteger(0);
        return getMaxDiff(array, 0, array.length - 1, max, min);
    }

    public static int getMaxDiff(int[] array, int begin, int end, AtomicInteger max,
                                 AtomicInteger min) {
        if (begin == end) {
            max.set(array[begin]);
            min.set(array[begin]);
            return Integer.MIN_VALUE;
        }
        int middle = begin + (end - begin) / 2;
        //数组前半部分的最小值与最大值
        AtomicInteger lMax = new AtomicInteger(0);
        AtomicInteger lMin = new AtomicInteger(0);
        // 数组后半部分的最小值与最大值（第一种情况）
        int leftMax = getMaxDiff(array, begin, middle, lMax, lMin);

        //数组后半部分的最大值和最小值
        AtomicInteger rMax = new AtomicInteger(0);
        AtomicInteger rMin = new AtomicInteger(0);
        //数组后半部分的最大差值（第二种情况）
        int rightMax = getMaxDiff(array, middle + 1, end, rMax, rMin);

        //接下来处理第三种情况
        int minMax = lMax.get() - rMin.get();
        //求数组的最大值
        if (lMax.get() > rMax.get()) {
            max.set(lMax.get());
        } else {
            max.set(rMax.get());
        }
        //求数组的最小值
        if (lMin.get() < rMax.get()) {
            min.set(lMin.get());
        } else {
            min.set(rMin.get());
        }
        // 求最大差值
        int allMax = (leftMax > rightMax) ? leftMax : rightMax;
        allMax = allMax > minMax ? allMax : minMax;
        return allMax;
    }



    public static void main(String[] args) {
        int[] array = {1, 4, 17, 3, 2, -5, 8};
        System.out.println(getMaxSub1(array));
        System.out.println(getMaxSub2(array));
    }
}
