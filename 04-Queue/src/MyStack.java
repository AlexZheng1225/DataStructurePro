import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Alex Zheng
 * @Date 2021/2/15 16:42
 * @Annotation leetcode225号问题：使用两个队列实现一个LIFO的栈
 */
public class MyStack {

    private Queue<Integer> queue1,queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
        //判断队列2中的数据是否为空，不为空的话添加到队列1中
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        //将队列1和队列2进行互换，也就是确保每次队列1都是空队列
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue2.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
        System.out.println();
    }

}
