package practice;

import java.util.Stack;

public class MinStack {

    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;
    public MinStack(){
        stack = new Stack();
    }

    public void push(int x) {
        if(x < min)
            min = x;
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        updateNextMin();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    private void updateNextMin() {
        min = stack.stream().reduce((x,y)->x<y?x:y).orElse(Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
