package Practice.Textbooks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;


/**
 * 找到数组中出现次数最多的元素
 */
public class Algorithm854 {
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
     * 方法一：开辟一个数组count 将数组元素都初始化为0
     * 遍历待求数组array 然后对count[array[i]]++,然后在求出数组中最大值，这种方法过于浪费内存空间
     * 方法二：利用map
     *
     * @param array
     * @return
     */
    public static int findMostFrequentInArray(int[] array) {
        int resuslt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                // 判断map中是否已经存在array
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        int msot = 0;
        //定义一个迭代器
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            // 调用一次next 指针就会向下移动一次 所以双列集合 需要一个变量保存next的返回值
            // Map.Entry 是Map中的一个接口，他的用途是表示一个映射项（里面有Key和Value）
            // Map.Entry里有相应的getKey和getValue方法，即JavaBean，让我们能够从一个项中取出Key和Value。
            Map.Entry entry = (Map.Entry) iterator.next();
            int key = (Integer) entry.getKey();
            int value = (Integer) entry.getValue();
            if (value > msot) {
                //更新key
                msot = value;
                resuslt = key;
            }
        }

        return resuslt;
    }


    public static void main(String[] args) {
        Random ra = new Random();
        int[] array = new int[15];
        for (int i = 0; i < 15; i++) {
            array[i] = ra.nextInt(10);//为了产生负数 减去70
        }
        printArray(array);
        System.out.println("--------------------------------------------------------------");
        System.out.println(findMostFrequentInArray(array));
    }

}
