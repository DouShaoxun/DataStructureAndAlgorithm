package Practice.Textbooks;

/**
 * 求一个二进制数字中1的个数
 */
public class Algorithm843 {

    public static int countOne1(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {//判断最后一位数字是否为1 时间复杂度为logn
                count++;
            }
            n >>= 1;//  n=n>>1;
        }
        return count;
    }

    public static int countOne2(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);//每进行一次运算 n当中当中 最高位的1就会消失 当n中1的个数比较少的时候 此算法效率高
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOne1(8));
        System.out.println(countOne1(7));
        System.out.println(countOne1(16));
        System.out.println("--------------------------------------");
        System.out.println(countOne2(8));
        System.out.println(countOne2(7));
        System.out.println(countOne2(16));
    }

}
