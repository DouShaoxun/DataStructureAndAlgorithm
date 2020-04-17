package Practice.Sort;


public class LinkedList {

    private Node head;//链表头的引用
    private int length;

    /**
     * 无参构造函数
     */
    public LinkedList() {
        this.head = null;
        this.length = 0;
    }

    public void setHead(Node head) {
        this.head = head;
    }


    public Node getHead() {
        return head;
    }


    /**
     * 添加结点
     *
     * @param d
     */
    public void addNode(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            this.length++;//长度加1
            return;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();//移动到下一个结点
        }
        temp.setNext(newNode);
        this.length++;//长度加1
    }


    /**
     * 获取长度
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     * 删除结点
     *
     * @param index
     * @return
     */
    public Boolean deleteNode(int index) {
        if (index < 0 || index > this.length) {
            return false;
        }
        if (index == 1) {
            head = head.getNext();//java自动释放资源 无需向C++那样
        }
        Node delNode = this.head;
        Node delNextNode = delNode.getNext();
        int count = 2;
        while (delNextNode != null) {
            if (count == index) {
                delNode.setNext(delNextNode.getNext());
                this.length--;
                return true;
            }
            delNode = delNode.getNext();
            delNextNode = delNode.getNext();
            count++;
        }
        return false;
    }

    /**
     * 插入排序
     */
    public void sort() {
        Node nextNode = null;
        int temp = 0;
        Node curNode = head;
        while (curNode.getNext() != null) {
            nextNode = curNode.getNext();
            while (nextNode != null) {
                if (curNode.getData() > nextNode.getData()) {
                    temp = curNode.getData();
                    curNode.setData(nextNode.getData());
                    nextNode.setData(temp);
                }
                nextNode = nextNode.getNext();
            }
            curNode = curNode.getNext();
        }
    }


    /**
     * 打印链表
     */
    public void printList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.printf("%4d", temp.getData());
            temp = temp.getNext();
        }
        System.out.println();
    }

    /**
     * 判断链表是否有序 升序
     *
     * @return
     */
    public boolean isOrder() {
        Node temp = this.head;
        Node key = temp.getNext();
        while (temp != null && key != null) {

            if (key.getData() < temp.getData()) {
                return false;
            }
            temp = temp.getNext();
            key = temp.getNext();
        }
        return true;
    }

    /**
     * 判断链表是否有序 降序
     *
     * @return
     */
    public boolean isOrder(boolean flag) {
        Node temp = this.head;
        Node key = temp.getNext();
        while (temp != null && key != null) {

            if (key.getData() > temp.getData()) {
                return false;
            }
            temp = temp.getNext();
            key = temp.getNext();
        }
        return true;
    }

}
