package Practice.Textbooks;

/**
 * 如何找出数组当中只出现一次的数字(其他数组都出现偶数次)
 * 要求时间复杂度O(n) 空间复杂度O(1)
 */
public class Algorithm858 {

    /**
     * 根据异或运算  任何一个数字异或它自己得到的结果都是0，所以从头到尾 一次异或数组中的每一个数字，
     * 出现偶数次的数字都会被消去  最终的结果就是出现1次的数字
     * @param array
     * @return
     */
    public static int findOneNum(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 4, 5, 6, 1, 1, 2, 3,  2, 6};
        System.out.println(findOneNum(array));
    }

}
