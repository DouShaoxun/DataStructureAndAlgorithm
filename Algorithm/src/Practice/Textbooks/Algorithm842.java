package Practice.Textbooks;


/**
 * 如何判断一个数字书否为2的n次方
 */
public class Algorithm842 {

    public static boolean isPower1(int n) {
        if (n < 1) {
            return false;
        }
        int i = 1;
        while (i <= n) {
            if (i == n) {
                return true;
            }
            i <<= 1;
        }
        return false;
    }

    public static boolean isPower2(int n) {
        if (n < 1) {
            return false;
        }
        // 如果一个数字是2的n次方，那么这个数的二进制形势只有最高位为1
        return (0 == (n & (n - 1)));
    }

    public static void main(String[] args) {
        System.out.println(isPower1(13));
        System.out.println(isPower1(16));
        System.out.println(isPower1(18));

        System.out.println("--------------------------------------");

        System.out.println(isPower2(150));
        System.out.println(isPower2(1024));
        System.out.println(isPower2(18));
    }

}
