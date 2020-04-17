package SegmentTree;

public class Main {

    public static void main(String[] args) {

        Integer[] nums = {-2, 0, 3, -5, 2, -1};
//        Integer[] nums = {1,2,3,4};
        // 构建线段树的时候 使用匿名内部类传入一个Merger接口的实现类实例对象
        SegmentTree<Integer> segTree = new SegmentTree<Integer>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segTree);
        System.out.println(segTree.query(1,3));
    }
}
