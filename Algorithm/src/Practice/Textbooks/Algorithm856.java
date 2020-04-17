package Practice.Textbooks;

import java.util.Arrays;
import java.util.Random;


/**
 * 如何把一个 数组向右循环移动k位
 * 例如 12345678  向右循环移动两位得到78123456
 */
public class Algorithm856 {
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
     * 以12345678为例子 向右移动2位
     * 先将123456和78 看出两部分 然后分别逆序 得到65432187
     * 再将65432187逆序即得到解 78123456
     *
     * @param array
     * @param k
     */
    public static void reverse(int[] array, int k) {
        k %= array.length;// 防止超出范围
        int index = array.length - k-1;

        for (int i = 0; i <= index / 2; i++) {
            int temp = array[i];
            array[i] = array[index - i ];
            array[index - i ] = temp;
        }
        for (int i = index+1; i < (index + array.length) / 2; i++) {
            int temp = array[i];
            array[i] = array[index + array.length - i ];
            array[index + array.length- i ] = temp;
        }
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i-1 ];
            array[array.length - i -1] = temp;
        }
    }

    public static void main(String[] args) {
        Random ra = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }
        printArray(array);
        System.out.println("--------------------------------------------------------------");
        reverse(array, 3);
        printArray(array);

    }

}
