package Stack_Array;

import StackInterface.Stack;
import Stack_Array.Impl.StackImplArray;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackImplArray<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
