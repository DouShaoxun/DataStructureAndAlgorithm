package Trie;

import java.util.TreeMap;

/**
 * 字典树
 */
public class Trie {
    /**
     * 内部类 结点
     * 包含一个 boolean类型的结束标记 isWord  用来标记 之前走过的结点路径 是否是一个已经存入的单词
     * TreeMap<Character, Node> 是一个树结构的map 指向下一个子 字典树
     */
    private class Node {

        public boolean isWord;
        public TreeMap<Character, Node> next;

        /**
         * 有参构造函数
         *
         * @param isWord
         */
        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;// 根节点
    private int size; //当前单词数量

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获得Trie中存储的单词数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word
     *
     * @param word
     */
    public void add(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                //向树Map中添加新的键值对
                cur.next.put(c, new Node());
            }

            // 移动到子树 Map上
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词word是否在Trie中
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        // 例如 panda 已经存入了 但是pan没有存入 则走到n结点的时候 对应的isword为false
        // 所以不能直接return true
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * 逻辑和contains方法几乎一样
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

}
