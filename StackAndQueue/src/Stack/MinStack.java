package Stack;

public class MinStack {
    private MyStack_Linklist<Integer> elem;
    private MyStack_Linklist<Integer> min;

    public MinStack() {
        elem = new MyStack_Linklist<>();
        min = new MyStack_Linklist<>();
    }

    public void push(int data) {
        elem.push(data);
        if (min.isEmpty()) {
            min.push(data);
        } else {
            if (data < min.peek()) {
                min.push(data);
            }
        }
    }

    public int pop() {
        int topData = elem.peek();
        elem.pop();
        if (topData == this.min()) {
            min.pop();
        }
        return topData;
    }

    public int min() {
        if (min.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return min.peek();
        }
    }
}
