package Practice.Textbooks;

/**
 * 如何找出数组当中只出现一次的数字(其他数组都出现n次)
 * 要求时间复杂度O(n) 空间复杂度O(1)
 */
public class Algorithm858_2 {
    /**
     * 假设这个数字为result,其他数字均出现了N次
     * 则去掉result之后的其他数字对应的二进制的每个位子出现的个数均为n的整数倍
     * 因此可以对数组中的所有的数字对应的二进制中各个位置上的1的个数对n去模,这样就可以得到出现1次的数字的二进制表现
     *
     * @param array
     * @return
     */
    public static int findOneNum(int[] array, int N) {
        int[] bitCount = new int[32];// 数组默认值为0

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 32; j++) {
                // 计算数组中所有数字对应二进制各个位置上出现1的次数总和
                bitCount[j] += ((array[i] >> j) & 1);
            }
        }
        // 求结果
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % N != 0) {
                // 某一位上的结果不能被N整除 则这一位肯定在结果所对应的二进制上
                result += (1 << i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 6, 7, 8, 4, 5, 6, 7, 8, 1, 2, 3, 4, 1, 2, 3, 4, 6, 7, 8};
        System.out.println(findOneNum(array, 3));
        int[] brray = {1, 1, 2, 3, 1, 2, 1, 2, 3, 3, 2, 3, 4};
        System.out.println(findOneNum(brray, 4));
    }

}
