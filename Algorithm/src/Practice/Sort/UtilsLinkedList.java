package Practice.Sort;

import java.util.Random;

/**
 * @Classname LinkedListUtils
 * @Created by Dsx
 */
public class UtilsLinkedList {
    LinkedList list=null;
    public UtilsLinkedList() {
        Random ra=new Random();
        list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.addNode(ra.nextInt(100));
        }
    }
    public UtilsLinkedList(int n) {
        Random ra=new Random();
        list = new LinkedList();
        for (int i = 0; i < n; i++) {
            list.addNode(ra.nextInt(100));
        }
    }
    public LinkedList getList(){
        return list;
    }
    public Node getHead(){
        return list.getHead();
    }
    public void setHead(Node Head){
        list.setHead(Head);
    }
    /**
     * 打印链表
     */
    public void printList() {
     list.printList();
    }

    /**
     * 判断链表是否有序 递增
     *
     * @return
     */
    public boolean isOrder() {
        return list.isOrder();
    }

    /**
     * 降序判断
     * @param flag
     * @return
     */
    public boolean isOrder(boolean flag) {
        return list.isOrder(flag);
    }
}
