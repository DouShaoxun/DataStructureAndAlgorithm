package Practice.LinkedList;


import java.util.Hashtable;

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

        newNode.setNext(head);
        head = newNode;
//        Node temp = head;
//        while (temp.getNext() != null) {
//            temp = temp.getNext();//移动到下一个结点
//        }
//        temp.setNext(newNode);
        this.length++;//长度加1
    }

    /**
     * 添加新节点
     *
     * @param newNode
     */
    public void addNode(Node newNode) {
        if (head == null) {
            head = newNode;
            this.length++;//长度加1
            return;
        }
        newNode.setNext(head);
        head = newNode;
//        Node temp = head;
//        while (temp.getNext() != null) {
//            temp = temp.getNext();//移动到下一个结点
//        }
//        temp.setNext(newNode);
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
     * 删除链表中重复元素  利用Map 时间复杂度O(n) 需要存储额外空间
     */
    public void delDuplecateN() {
        //key存储data  value存储出现次数
        Hashtable<Integer, Integer> table = new Hashtable<>();
        Node tmp = head;
        Node pre = null;
        while (tmp != null) {
            if (table.containsKey(tmp.getData())) {// 判断的当前元素是否在容器中出现
                pre.setNext(tmp.getNext());//删除
                this.length--;
            } else {
                table.put(tmp.getData(), 1);// 添加到容器里
                pre = tmp;
            }
            tmp = tmp.getNext();
        }
    }

    /**
     * 删除链表中重复元素  双重遍历(类似两个for循环) 时间复杂度O(n²) 不需要额外空间
     */
    public void delDuplecateN2() {
        Node p = head;
        while (p != null) {
            Node q = p;
            while (q.getNext() != null) {
                if (p.getData() == q.getNext().getData()) {
                    q.setNext(q.getNext().getNext());
                    this.length--;
                } else {
                    q = q.getNext();
                }
            }
            p = p.getNext();
        }
    }

    /**
     * 查找到链表中倒数第k个元素
     *
     * @param k
     * @return
     */
    public Node CountdownKindex1(int k) {
        /**
         * 先求出链表的长度Length ， 然后指针从头结点移动Length - k + 1次
         */
        if (k < 1 || k > this.getLength()) {
            return null;
        }
        int end = this.getLength() - k + 1;
        int i = 0;
        Node temp = head;
        while (i < end && temp != null) {
            temp = temp.getNext();
            i++;
        }
        return temp;
    }


    /**
     * 查找到链表中倒数第k个元素
     * 双指针 快指针 先行执行先走k步 然后两个指针同时走动,当快指针走到尾部的时候 满指针就是倒数第k个元素
     * @param k
     * @return
     */
    public Node CountdownKindex2(int k) {
        //此方法假设 没有存储链表长度的变量
        if (k < 1) {
            return null;
        }
        Node p1 = head;//快指针  先走k步
        Node p2 = head;//满指针
        //双指针 快指针 先行执行先走k步
        for (int i = 0; i < k - 1 && p1 != null; i++) {
            p1 = p1.getNext();
        }
        if (p1 == null) {
            //给出的k超过链表长度
            return null;
        }
        while (p1.getNext() != null) {
            //两个指针同时移动
            //当快指针移动到尾部的时候 p2即为所求
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        return p2;
    }

    /**
     * 递归 逆向输出链表
     *
     * @param node
     */
    public void printRevesely(Node node) {
        //还可以利用栈  遍历一遍一次入栈,然后在依次取出栈中元素
        if (node != null) {
            printRevesely(node.getNext());
            System.out.print(node + "    ");
        }
    }

    /**
     * 链表反转
     * Head -> * -> * -> * -> * -> A -> B -> C -> * -> * -> * -> * -> null
     * null <- * <- * <- * <- * <- A -> B -> C -> * -> * -> * -> * -> null
     * null <- * <- * <- * <- * <- A <- B -> C -> * -> * -> * -> * -> null
     * null <- * <- * <- * <- * <- A <- B    C -> * -> * -> * -> * -> null  // 相当于链表断开了 所以要用pNext保存C这个结点
     *
     */
    public void ReveselyList() {
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null) {
            // a->b->c  由于是单链表 所以让b指向a之前 应当保存c否则链表就断了
            //保存下一个结点
            Node pNext = pNode.getNext();
            if (pNext == null) {
                //最后一个结点  保存 等会赋值给头结点
                pReversedHead = pNode;
            }
            //改变指向
            pNode.setNext(pPrev);
            //指向当前结点 用于下一次改变指向
            pPrev = pNode;
            //向后移动一个结点
            pNode = pNext;
        }
        this.head = pReversedHead;
    }

    /**
     * 寻找链表中间元素
     *
     * @return
     */
    public Node[] SeachMid() {
        //在不知道结点长度情况下 定义两个指针从head开始
        //快指针一次走两步，慢指针一次走一步 快指针为null是慢指针即为所求
        //如果长度为奇数慢指针即为所求,如果是偶数则慢指针和慢指针的下一个结点均为所求
        Node p1 = head;
        Node p2 = head;
        int count = 0;
        while (p1 != null && p1.getNext() != null && p1.getNext().getNext() != null) {
            p1 = p1.getNext().getNext();
            p2 = p2.getNext();
            count++;
        }
        if (count % 2 == 0) {
            return new Node[]{
                    p2, p2.getNext()
            };
        } else {
            return new Node[]{p2};
        }
    }


    /**
     * 判断一个链表是否有环
     *
     * @return
     */
    public boolean IsLoop() {
        if (head == null) {
            return false;
        }
        /**
         * 两个指针：
         *      快指针一次走两步
         *      慢指针一次走一步
         *      如果两个指针会碰头则说明链表有环存在
         */
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    /**
     * 构建有环链表   进行是否有环测试
     */
    public void CloseLoop(int Ent) {
        if (this.getLength() < 4 || Ent > this.getLength()) {
            //为了让测试有意义 保证链表长度在4个以上
            return;
        }
        Node Tail = head;
        Node Entrance = head;
        int count = 1;
        while (count < Ent) {
            //将第Ent个点作为环的入口
            Entrance = Entrance.getNext();
            count++;
        }
        while (Tail.getNext() != null) {
            //拿到尾部结点
            Tail = Tail.getNext();
        }
        Tail.setNext(Entrance);//闭环
    }

    /**
     * 找到环入口
     *
     * @return
     */
    public Node FindLoopPort() {
        Node slow = head;   //慢指针一次走一步
        Node fast = head;   //快指针一次走两步
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                break;//找到快指针和慢指针的交点
            }
        }
        //如果交点为空  说明没有闭环
        if (fast == null || fast.getNext() == null) {
            return null;
        }
        slow = head;//慢指针重新指向头结点  然后快指针此时改成一次走一步 在环里打转
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }

    /**
     * 判断链表是否相交 并且返回交点
     *
     * @param H
     * @return
     */
    public Node getFirstMeeNode(Node H) {
        if (head == null || H == null) {
            return null;
        }
        Node tail1 = head;
        Node tail2 = H;
        int len1 = 1;//长度初始化为1是为了遍历到尾节点
        int len2 = 1;
        //求长度的同时 把tail分别指向链表的尾部结点
        while (tail1.getNext() != null) {
            tail1 = tail1.getNext();
            len1++;
        }
        while (tail2.getNext() != null) {
            tail2 = tail2.getNext();
            len2++;
        }
        // 如果两个链表相交尾结点一定相同 反之两链表不相交
        if (tail1 != tail2) {
            return null;
        }
        Node t1 = head;
        Node t2 = H;
        /**
         *  把较长的链表多余的结点先遍历 剩下的结点 同时遍历
         *  并判断结点是否相同 第一个相同的即为交点
         *  A1->B1->C->D->E->null
         *  A2->B2->C2->D2->C->D->E->null
         *  交点为C
         *  应当先把长链表多余的结点遍历了 让指针指向C2 然后两个链表同时遍历并判断当前指针是否相同
         *  相同 即为  交点
         */
        if (len1 > len2) {
            int d = len1 - len2;
            while (d != 0) {
                t1 = t1.getNext();
                d--;
            }
        } else {
            int d = len2 - len1;
            while (d != 0) {
                t2 = t2.getNext();
                d--;
            }
        }
        while (t1 != t2) {
            // 第一次相同的结点即为交点
            t1 = t1.getNext();
            t2 = t2.getNext();
        }
        return t1;
    }

    /**
     * 在不知道头指针的情况下删除指定结点
     *
     * @param n
     * @return
     */
    public boolean deleteNode(Node n) {
        if (n == null || n.getNext() == null) {
            //如果是尾部结点则不能删除
            return false;
        }
        int tmp = n.getData();
        n.setData(n.getNext().getData());
        n.getNext().setData(tmp);
        n.setNext(n.getNext().getNext());
        this.length--;
        // -->A(3)-->B(5)-->C(6)-->
        // 需求是删除A结点
        // 上面操作过后变成了
        // -->A(5)-->C(6)-->
        //    B(3)-->C(6)-->
        // 相当于B变成了链表上的一个分支 且B没有前驱节点  没有对象指向B,B会自动释放掉
        return true;
    }
}
