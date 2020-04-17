package MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        linkedList.addLast(100);
        linkedList.add(2,10);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);


    }
}
