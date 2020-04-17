package Practice.Textbooks;

import java.util.Random;

/**
 * 如何求最大子数组之和：
 * 一个数组有n个元素 数组中连续的一个或者多个元素可以组成一个连续的子数组
 * 求子数组和的最大值
 */
public class Algorithm853 {
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
     * 暴力 找到所有子数组 此方法时间复杂度较大O(n³)
     *
     * @param array
     * @return
     */
    public static int MaxSubArray1(int[] array) {
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int TempSum = 0;
                for (int k = i; k <= j; k++) {
                    TempSum += array[k];
                }
                if (TempSum > maxSum) {
                    maxSum = TempSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 方法二：重复利用已经求出的子数组和
     * 时间复杂度O(n²)
     * sum[i,j]=sum[i,j-1]+array[j]
     * 可以省去计算sum[i,j-1]的开销
     *
     * @param array
     * @return
     */
    public static int MaxSubArray2(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int TempSum = 0;//临时最大值
            for (int j = i; j < array.length; j++) {
                TempSum += array[j];
                if (TempSum > maxSum) {
                    maxSum = TempSum;
                }
            }
        }
        return maxSum;
    }

    public static int max(int m, int n) {
        return m > n ? m : n;
    }

    /**
     * 方法三：动态规划  时间复杂度O(n)
     * 假设数组长度为n，则数组最后一个元素array[n-1]与最大子数组的关系有一下三种情况：
     * (1).最大子数组由array[n-1]单独构成
     * (2).最大子数组包含array[n-1]
     * (3).最大子数组不包含array[n-1]，即将问题从求[0,n)转换为求[0,n-1)的最大子数组和
     * All[i]表示[0,i]的最大子数组和
     * End[i]表示包含array[i]的最大子数组和
     * array[i]表示当前元素的值
     * 则 All[i]=max{All[i-1],array[i],End[i]}
     *
     * @param array
     * @return
     */
    public static int MaxSubArray3(int[] array) {
        int n = array.length;
        int[] End = new int[n];
        int[] All = new int[n];
        End[n - 1] = array[n - 1];
        All[n - 1] = array[n - 1];
        End[0] = All[0] = array[0];
        for (int i = 1; i < n; i++) {
            End[i] = max(End[i - 1] + array[i], array[i]);
            All[i] = max(End[i], All[i - 1]);
        }
        return All[n - 1];
    }

    /**
     * 方法四：在方法的基础上我们发现 每次都只用到End[i]和 All[i]而不是用到整个数组的值
     * 所以我们可以定义两个变量保存这两个值 这样既可以减小内存开销，又可以控制时间复杂度为O(n)
     *
     * @param array
     */
    public static int MaxSubArray4(int[] array) {
        int n = array.length;
        int End = array[0];
        int All = array[0];
        for (int i = 1; i < n; i++) {
            End = max(End + array[i], array[i]);
            All = max(End, All);
        }
        return All;
    }

    /**
     * 求出最大子数组和的同时找到起始位置以及终止位置
     * End[i]=max( End[i-1]+array[i],array[i])
     * 如果 End[i-1]<0，则End[i]的值应当为array[i] 此时应当更新起始位置
     *
     * @param array
     * @return
     */
    public static int MaxSubArray5(int[] array) {
        int maxNum = Integer.MIN_VALUE;
        int nSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (nSum < 0) {
                nSum = array[i];

                begin=i;
            } else {
                nSum += array[i];//累加
            }

            if (nSum > maxNum) {
                maxNum = nSum;//更新最大值 以及结束位置
                end = i;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        Random ra = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = ra.nextInt(100) - 70;//为了产生负数 减去70
        }
        printArray(array);
        System.out.println("--------------------------------------");
        System.out.println(MaxSubArray1(array));
        System.out.println("--------------------------------------");
        System.out.println(MaxSubArray2(array));
        System.out.println("--------------------------------------");
        System.out.println(MaxSubArray3(array));
        System.out.println("--------------------------------------");
        System.out.println(MaxSubArray4(array));
        System.out.println("--------------------------------------");
        System.out.println(MaxSubArray5(array));

        System.out.println("--------------------------------------");
        System.out.print("begin:" + begin + "    ");
        System.out.println("end:" + end);
    }

}
