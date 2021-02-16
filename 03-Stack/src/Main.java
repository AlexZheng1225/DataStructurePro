import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Random;

/**
 * @Author Alex Zheng
 * @Date 2021/2/14 17:50
 * @Annotation
 */
public class Main {

    //使用Stack运行opCount个push和pop操作所需的事件，单位秒
    private static double testStack(Stack<Integer> q,int opCount){

        long start = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.pop();
        }

        long end = System.nanoTime();

        return (end-start)/1000000000.0;

    }

    public static void main(String[] args) {
        int opCount = 10000000;

        //二者都是O(n)，复杂度上看并没有太大差别
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("arrayStack: " + time1 + "s"); //arrayStack: 4.3886255s

        //对于链表栈来说，opCount过多会导致每次都要new一个新的Node进而导致执行时间变长
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("linkedListStack: " + time2 + "s"); //linkedListStack: 4.5679196s
    }

}
