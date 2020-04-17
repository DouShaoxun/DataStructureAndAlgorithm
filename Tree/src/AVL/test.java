package AVL;

import Trie.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class test {
    @Test
    public void test1() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("E:\\Code\\Java\\DataStructureAndAlgorithm\\Tree\\src\\AVL" +
                "\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            Collections.sort(words);//排序之后 一般的平衡二叉树 退化成 “链表”

            // Test BST
            long startTime = System.nanoTime();

            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for (String word : words)
                bst.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");


            // Test AVL
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for (String word : words) {
                // 判断是否包含word
                avl.contains(word);
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");
            for (String word : words) {
                avl.remove(word);
                if(!avl.isBST()||!avl.isBalanced()){
                    throw new RuntimeException("error No BST or No Balanced");
                }
            }
        }
    }

}
