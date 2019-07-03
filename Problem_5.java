import java.util.Stack;

class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    private int front;

    public void push(int x) {
        if (s1.empty())
            front = x;
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    // Removes the element from the front of queue.
    public void pop() {
        s1.pop();
        if (!s1.empty())
            front = s1.peek();
    }

    // Get the front element.
    public int peek() {
        return front;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.pop();
        System.out.print(obj.peek() + "\n");
        System.out.print(obj.empty());
    }

}
