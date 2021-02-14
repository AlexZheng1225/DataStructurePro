import org.omg.CORBA.Object;

/**
 * @Author Alex Zheng
 * @Date 2021/2/14 21:23
 * @Annotation
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        //有意识的浪费一个空间 为（tail+1）%size做条件
        data = (E[]) new Object[capacity + 1];
        front = tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }
}
