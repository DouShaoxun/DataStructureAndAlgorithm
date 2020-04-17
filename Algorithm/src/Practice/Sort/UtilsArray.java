package Practice.Sort;

import java.util.Random;

/**
 * @Classname ArrayUtils
 * @Created by Dsx
 */
public class UtilsArray {
    int[] array = null;

    public UtilsArray() {
        Random ra = new Random();
        array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = ra.nextInt(100);
        }
    }
    public UtilsArray(int n) {
        Random ra = new Random();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = ra.nextInt(100);
        }
    }
    public  int[] getArrray(){
        return array;
    }
    public  void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%4d", array[i]);
        }
        System.out.println();
    }
    /**
     * 判断是否有序  升序
     * @param
     * @return
     */
    public  boolean isOrder() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 降序判断
     * @param flag
     * @return
     */
    public  boolean isOrder(boolean flag) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public int getlength(){
        return array.length;
    }
}
