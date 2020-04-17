package Stack_LinkedList;


import StackInterface.Stack;
import Stack_LinkedList.Impl.StackImplLinkedList;

public class Main {


    public static void main(String[] args) {
        Stack<Integer> stack = new StackImplLinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        // 自定义数据类型测试
        Stack<Student> studentStack=new StackImplLinkedList<>();
        for (int i = 0; i < 8; i++) {
            studentStack.push(new Student("Tom", 18 + i));
        }
        while(!studentStack.isEmpty()){
            System.out.println(studentStack.pop());
        }
    }
}
