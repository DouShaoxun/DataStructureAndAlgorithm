package Practice.Linkedlist;

import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void testAdd() {
        MyLinkedList mylist = new MyLinkedList();
        mylist.addNode(10);
        mylist.addNode(7);
        mylist.addNode(12);
        mylist.addNode(1);
        mylist.addNode(-7);
        mylist.addNode(8);
        mylist.printList();
    }

    @Test
    public void testDel() {
        MyLinkedList mylist = new MyLinkedList();
        mylist.addNode(10);
        mylist.addNode(7);
        mylist.addNode(12);
        mylist.addNode(1);
        mylist.addNode(-7);
        mylist.addNode(8);
        mylist.deleteNode(1);
        mylist.deleteNode(4);
        mylist.printList();
    }

    @Test
    public void testSort() {
        MyLinkedList mylist = new MyLinkedList();
        mylist.addNode(10);
        mylist.addNode(7);
        mylist.addNode(12);
        mylist.addNode(1);
        mylist.addNode(-7);
        mylist.addNode(8);
        mylist.sort();
        mylist.printList();
    }

    @Test
    public void testDelDupN() {
        MyLinkedList mylist = new MyLinkedList();
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 4; j++) {
                mylist.addNode(i);
            }
        }

        mylist.delDuplecateN();
        mylist.printList();
    }

    @Test
    public void testDelDupN2() {
        MyLinkedList mylist = new MyLinkedList();
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 4; j++) {
                mylist.addNode(i);
            }
        }

        mylist.delDuplecateN2();
        mylist.printList();
    }

    @Test
    public void testCountdownKindex1() {
        MyLinkedList mylist = new MyLinkedList();
        for (int i = 1; i <= 15; i++) {
            mylist.addNode(i);
        }
        Node node = mylist.CountdownKindex1(100);
        System.out.println(node);
        node = mylist.CountdownKindex1(5);
        System.out.println(node);
        node = mylist.CountdownKindex1(-1);
        System.out.println(node);
    }

    @Test
    public void testCountdownKindex2() {
        MyLinkedList mylist = new MyLinkedList();
        for (int i = 1; i <= 15; i++) {
            mylist.addNode(i);
        }
        Node node = mylist.CountdownKindex1(113);
        System.out.println(node);
        node = mylist.CountdownKindex1(7);
        System.out.println(node);
        node = mylist.CountdownKindex1(-1);
        System.out.println(node);
    }

    @Test
    public void testPrintRevesely() {
        MyLinkedList mylist = new MyLinkedList();
        for (int i = 1; i <= 6; i++) {
            mylist.addNode(i);
        }
        mylist.printRevesely(mylist.getHead());
    }

    @Test
    public void testReveselyList() {
        MyLinkedList mylist = new MyLinkedList();
        for (int i = 1; i <= 6; i++) {
            mylist.addNode(i);
        }
        mylist.printList();
        mylist.ReveselyList();
        mylist.printList();
    }

    @Test
    public void testSeachMid() {
        MyLinkedList mylist = new MyLinkedList();
        for (int i = 1; i <= 6; i++) {
            mylist.addNode(i);
        }
        Node[] node = mylist.SeachMid();
//        System.out.println(node);
        for (Node nodeTmp : node) {
            System.out.println(nodeTmp);
        }
    }

    @Test
    public void testIsLoop() {
        MyLinkedList mylist = new MyLinkedList();
        for (int i = 1; i <= 6; i++) {
            mylist.addNode(i);
        }
        System.out.println(mylist.IsLoop());
        mylist.printList();
        mylist.CloseLoop(4);//产生闭环 指定环的入口位置
        System.out.println(mylist.IsLoop());
//        mylist.printList();
        Node LoopPort = mylist.FindLoopPort();
        System.out.println(LoopPort);//输出环的入口位置
    }

    @Test
    public void testGetFirstMeeNode() {
        //交点
        Node FirstMeetNode = new Node(-100);
        //链表1
        MyLinkedList mylist1 = new MyLinkedList();
        for (int i = 1; i <= 2; i++) {
            mylist1.addNode(i);
        }
        mylist1.addNode(FirstMeetNode);
        //链表2
        MyLinkedList mylist2 = new MyLinkedList();
        for (int i = 10; i <= 14; i++) {
            mylist2.addNode(i);
        }
        mylist2.addNode(FirstMeetNode);

        for (int i = 0; i < 3; i++) {
            //链表1尾部继续添加
            mylist1.addNode((i + 1) * 10);
        }
        mylist1.printList();
        mylist2.printList();
        System.out.println("==================");
        //链表2尾部 添加结点
        mylist2.addNode(190);
        mylist1.printList();
        mylist2.printList();
        //找到交点
        Node tmp = mylist1.getFirstMeeNode(mylist2.getHead());
        System.out.println(tmp);

        //链表3
        MyLinkedList mylist3 = new MyLinkedList();
        for (int i = 20; i <= 25; i++) {
            mylist3.addNode(i);
        }
        tmp = mylist1.getFirstMeeNode(mylist3.getHead());
        System.out.println(tmp);
        tmp = mylist2.getFirstMeeNode(mylist3.getHead());
        System.out.println(tmp);


    }

    @Test
    public void testDeleteNode(){

        Node node = new Node(-100);
        MyLinkedList mylist = new MyLinkedList();
        for (int i = 1; i <= 2; i++) {
            mylist.addNode(i);
        }
        mylist.addNode(node);
        mylist.addNode(10);
        mylist.printList();
        mylist.deleteNode(node);
        mylist.printList();
    }
}
