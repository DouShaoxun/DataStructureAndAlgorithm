package ForkTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 * @param <E>
 */
public class BST<E extends Comparable<E>> {
    /**
     * 结点
     */
    private class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

//    /**
//     * 向二分搜索树中添加元素
//     *
//     * @param e
//     */
//    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, new Node(e));
//        }
//    }

    //    /**
//     * 内部递归 private
//     *
//     * @param node
//     * @param root
//     */
//    private void add(Node root, Node node) {
//        if (root.e.equals(node.e)) {
//            return;
//        } else if (root.e.compareTo(node.e) < 0 && root.left == null) {
//            //非基础类型比较 compareTo
//            root.left = node;
//            size++;
//            return;
//        } else if (root.e.compareTo(node.e) > 0 && root.right == null) {
//            root.right = node;
//            size++;
//            return;
//        }
//
//        // 递归
//        if (root.e.compareTo(node.e) > 0) {
//            add(root.right, node);
//        } else {
//            add(root.left, node);
//        }
//    }

    /**
     * 改进插入算法
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, new Node(e));
    }

    /**
     * 递归
     *
     * @param root
     * @param node
     * @return
     */
    private Node add(Node root, Node node) {
        if (root == null) {
            size++;
            return node;
        }
        // 递归
        if (root.e.compareTo(node.e) > 0) {
            root.left = add(root.left, node);
        } else if (root.e.compareTo(node.e) < 0) {
            root.right = add(root.right, node);
        }
        return root;
    }

    /**
     * 判断当前二分搜索树中有否 有 元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(e, root);
    }

    private boolean contains(E e, Node root) {
        if (root == null) {
            return false;
        } else {
            if (root.e.compareTo(e) == 0) {
                return true;
            } else if (root.e.compareTo(e) < 0) {
                return contains(e, root.left);
            } else {
                return contains(e, root.right);
            }
        }
    }

    /**
     * 先序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }


    /**
     * 二分搜索树的非递归前序遍历
     */
    public void preOrderNR(){

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }


    /**
     * 后序遍历
     */
    public void lrdOrder() {
        lrdOrder(root);
    }
    private void lrdOrder(Node root) {
        if (root == null) {
            return;
        }
        lrdOrder(root.left);
        lrdOrder(root.right);
        System.out.println(root.e);
    }


    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder(){

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null)
                q.add(cur.left);
            if(cur.right != null)
                q.add(cur.right);
        }
    }


    /**
     *  寻找二分搜索树的最小元素
     * @return
     */
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node minNode = minimum(root);
        return minNode.e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if( node.left == null )
            return node;

        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     * @return
     */
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     * @param node
     * @return
     */
    private Node maximum(Node node){
        if( node.right == null )
            return node;

        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     *  删除掉以node为根的二分搜索树中的最小节点
     *  返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }









    /**
     * 查看当前二分搜索树中的结点数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 从二分搜索树中删除元素为e的节点
     * @param e
     */
    public void remove(E e){
        root = remove(root, e);
    }

    /**
     *     删除掉以node为根的二分搜索树中值为e的节点, 递归算法
     *    返回删除节点后新的二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e){

        if( node == null )
            return null;

        if( e.compareTo(node.e) < 0 ){
            node.left = remove(node.left , e);
            return node;
        }
        else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            return node;
        }
        else{   // e.compareTo(node.e) == 0

            // 情况1：待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 情况2：待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 情况3：待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

}
