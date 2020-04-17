package Practice.Textbooks;

import java.util.Random;

/**
 * 求数组中的最大值和最小值
 */
public class Algorithm851 {
    public static int max;
    public static int min;

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
     * 取单元素法 比较次数为2N
     *
     * @param array
     */
    public static void MaxMin1(int[] array) {
        min = array[0];
        max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
    }

    /**
     * 取双元素法 比较次数为1.5N
     *
     * @param array
     */
    public static void MaxMin2(int[] array) {
        min = array[0];
        max = array[0];
        for (int i = 1; i < array.length - 1; i++) {
            if (i + 1 > array.length) {
                //比较最后一个元素
                if (array[i] < min) {
                    min = array[i];
                }
                if (array[i] > max) {
                    max = array[i];
                }
            }
            // 取出两个元素array[i]和array[i+1] 先进行比较大小
            // 然后大的和max比较 小的和min比较
            int tempMax = array[i] > array[i + 1] ? array[i] : array[i + 1];
            int tempMin = array[i] < array[i + 1] ? array[i] : array[i + 1];
            max = tempMax > max ? tempMax : max;
            min = tempMin < min ? tempMin : min;
        }
    }

    /**
     * 数组元素位移法  比较次数为1.5N~2N  但是改变了数组元素结构
     *
     * @param array
     */
    public static void MaxMin3(int[] array) {
        for (int i = 0; i < array.length - 1; i += 2) {
            int tempMax = array[i] > array[i + 1] ? array[i] : array[i + 1];
            int tempMin = array[i] < array[i + 1] ? array[i] : array[i + 1];
            array[i] = tempMax;
            array[i + 1] = tempMin;
        }
        //扫描偶数下标 求大数
        max = array[0];
        for (int i = 2; i < array.length; i += 2) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //扫描奇数下标 求小数
        min = array[1];
        for (int i = 3; i < array.length; i += 2) {
            if (array[i] < min) {
                min = array[i];
            }
        }
    }


    public static void main(String[] args) {
        Random ra = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = ra.nextInt(100);
        }
        printArray(array);
        MaxMin1(array);
        System.out.println(max);
        System.out.println(min);
        System.out.println("--------------------------------------");
        MaxMin2(array);
        System.out.println(max);
        System.out.println(min);
        System.out.println("--------------------------------------");
        MaxMin3(array);
        System.out.println(max);
        System.out.println(min);


    }

}
