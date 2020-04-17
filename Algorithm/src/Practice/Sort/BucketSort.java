package Practice.Sort;

import java.util.ArrayList;
import java.util.Comparator;

public class BucketSort {
    /**
     * 桶排序又叫箱排序，是计数排序的升级版，它的工作原理是将数组分到有限数量的桶子里，
     * 然后对每个桶子再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序），
     * 最后将各个桶中的数据有序的合并起来。
     *
     * 计数排序是桶排序的一种特殊情况，可以把计数排序当成每个桶里只有一个元素的情况。
     * 网络中很多博文写的桶排序实际上都是计数排序，并非标准的桶排序，要注意辨别。
     */
    /**
     * 找出待排序数组中的最大值max、最小值min
     * 我们使用 动态数组ArrayList 作为桶，桶里放的元素也用 ArrayList 存储。桶的数量为(max-min)/arr.length+1
     * 遍历数组 arr，计算每个元素 arr[i] 放的桶
     * 每个桶各自排序
     * 遍历桶数组，把排序好的元素放进输出数组
     *
     * @param array
     */
    public static void bucketSortArray(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            //获取当前数组的最值
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }
        //桶的数量 bucketNum
        int bucketNum = (max - min) / array.length + 1;
        //动态数组ArrayList 作为桶 ， 桶里放的元素也用 ArrayList 存储
        //bucketArr是管理桶的动态数组
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            //创建所有的桶
            bucketArr.add(new ArrayList<Integer>());
        }
        //将每个元素放入桶
        for (int i = 0; i < array.length; i++) {
            //计算array[i] 应该放到哪个桶里
            int num = (array[i] - min) / (array.length);
            bucketArr.get(num).add(array[i]);
        }
        System.out.println(bucketArr.toString());

        //对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            //对每个桶分别排序 这里可以使用其他排序算法实现
            bucketArr.get(i).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
//                    return o2 - o1;
                }
            });

        }
        //查看排序之后的桶数据
        System.out.println(bucketArr.toString());

        // 赋值给原数组
        int resI = 0;
        for (ArrayList<Integer> integers : bucketArr) {
            for (Integer integer : integers) {
                array[resI++] = integer;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("桶排序：数组实现");
        UtilsArray array =new UtilsArray();
        System.out.println("有序:" +array.isOrder());
        bucketSortArray(array.getArrray());
        System.out.println("有序:" +array.isOrder());


    }
}