package Practice.Textbooks;

/**
 * 数组array[N]中 存放了 [1,N)  其中有个数字重复了一次
 * 写一个函数找出这个数字 要求 一个数字只能访问一次，且不能用辅助空间
 */
public class Algorithm859 {
    /**
     * 方法一：求和法
     *
     * @param array
     * @return
     */
    public static int findTwoNum1(int[] array) {
        int sum = 0;
        int N = array.length;
        for (int i = 0; i < N; i++) {
            sum += array[i];
        }
        int result = sum - ((N - 1) * (1 + N - 1) / 2);
        return result;
    }

    /**
     * 方法二：异或法
     * 每两个不同的数字异或运算之后的结果均为1，两个相同的数字异或运算的结果是0
     * 将数组中所有的数字进行异或运算，再与1~N-1 进行异或运算
     * 最后结果即为所求
     *
     * @param array
     * @return
     */
    public static int findTwoNum2(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
            result ^= i;
        }
        return result;
    }

    /**
     * 方法三：如果允许开辟新的辅助空间 可以用空间换时间
     * 申请一个辅助数组flag长度为N，初始化为false
     * 取出array[i]的时候 同时标记flag[array[i]]=true;
     *
     * @param array
     * @return
     */
    public static int findTwoNum3(int[] array) {
        boolean[] flag = new boolean[array.length];
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (!flag[array[i]]) {
                flag[array[i]] = true;
            } else {
                result = array[i];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        System.out.println(findTwoNum1(array));
        System.out.println(findTwoNum2(array));
        System.out.println(findTwoNum3(array));
    }

}
