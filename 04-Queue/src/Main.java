import java.util.Random;

/**
 * @Author Alex Zheng
 * @Date 2021/2/14 22:21
 * @Annotation
 */
public class Main {

    //使用q运行opCount个enqueue和dequeue操作所需的事件，单位秒
    private static double testQueue(Queue<Integer> q,int opCount){

        long start = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long end = System.nanoTime();

        return (end-start)/1000000000.0;

    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue: " + time1 + "s"); //ArrayQueue: 6.1197189s

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue: " + time2 + "s"); //LoopQueue: 0.022479s

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue: " + time3 + "s"); //LinkedListQueue: 0.0175818s
    }

}
