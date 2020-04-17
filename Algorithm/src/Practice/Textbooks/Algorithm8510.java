package Practice.Textbooks;

/**
 * 如何用递归求一个整数数组中的最大元素
 */
public class Algorithm8510 {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * 打擂台 递归形式
     * 递归的思想：数组的第一个元素和数组其他元素组成的子数组当中的最大值比较  得到的最大值 即为所求
     * @param array
     * @param begin
     * @return
     */
    public static int maxNum(int[] array, int begin) {
        if (array.length - begin <= 1) {
            // 判断是否走到数组末尾了 走到末尾的时候 begin==array.lenght-1
            return array[begin];
        } else {
            return max(array[begin], maxNum(array, begin + 1));
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 8, 7, 15, 6, 3, 1};
        System.out.println(maxNum(array, 0));
    }

}
