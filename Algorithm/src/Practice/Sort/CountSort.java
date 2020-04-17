package Practice.Sort;


public class CountSort {
    /**
     * 计数排序：数组实现
     * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
     * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
     * <p>
     * 算法描述
     * 找出待排序的数组中最大和最小的元素；
     * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
     * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
     * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
     *
     * @param array
     * @param max
     * @param min
     */
    public static void countSort(int[] array, int max, int min) {
        int[] b = new int[array.length];//存储数组
        int[] count = new int[max - min + 1];//计数数组   count[0]记录的就是min出现的次数

        for (int num = min; num <= max; num++) {
            //初始化各元素值为0，数组下标从0开始因此减min
            count[num - min] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            count[num - min]++;//每出现一个值，计数数组对应元素的值+1
        }

        for (int num = min + 1; num <= max; num++) {
            //加总数组元素的值为计数数组对应元素及左边所有元素的值的总和
            count[num - min] += count[num - min - 1];
        }
        for (int i = 0; i < array.length; i++) {
            int num = array[i];//源数组第i位的值
            int index = count[num - min] - 1;//加总数组中对应元素的下标
            count[num - min]--;//加总数组中，该值的总和减少1。  方便求出相同元素的位置
            b[index] = num;//将该值存入存储数组对应下标中
        }

        //将存储数组的值一一替换给源数组
        for (int i = 0; i < array.length; i++) {
            array[i] = b[i];
        }
    }



    public static void main(String[] args) {
        System.out.println("计数排序：数组实现");
        UtilsArray array =new UtilsArray();
        System.out.println("有序:" +array.isOrder());
        countSort(array.getArrray(),100,0);
        System.out.println("有序:" +array.isOrder());
        /**
         *   13  19  18  10  18  17  15  19  18  17
         *    0   1   2   3   4   5   6   7   8   9  10
         *    1   1   1   2   2   3   3   5   8  10  10
         *   10  13  15  17  17  18  18  18  19  19
         *   count[8]与count[7]的值差3 说明 min+8 这个数据出现了三次
         *   且这三个数字最后那个数字的下标index为 8-1，其他两个在依次减去1
         */

    }

}
