package MaxHeap;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        int[] array = {19, 17, 15, 41, 30, 62, 28, 16, 22, 13};
        for (int i = 0; i < array.length; i++) {
            maxHeap.add(array[i]);
        }
        System.out.println(maxHeap);
        while(!maxHeap.isEmpty()){
            // 依次取出最大值 堆排序
            System.out.print(maxHeap.extractMax()+"     ");
        }
    }
}
