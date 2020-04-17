package ForkTree;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        int[] nums = {5, 3, 6, 8, 4, 2};
//        int[] nums = {1,2,3,4,5,8,0};
        for (int num : nums) {
            bst.add(num);
        }
//        bst.preOrder();   // 先序
//        bst.preOrderNR(); // 先序 非递归 栈实现
//        bst.inOrder();    // 中序
//        bst.lrdOrder();   // 后序
//        bst.levelOrder(); // 层次遍历  队列实现
//        System.out.println(bst);// 重写toString  先序
    }
}
