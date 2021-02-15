/**
 * @Author Alex Zheng
 * @Date 2021/2/14 21:23
 * @Annotation 浪费一个空间，但不适用size实现循环队列
 */
public class LoopQueue3<E> implements Queue<E> {

    private E[] data;
    private int front, tail;

    public LoopQueue3(int capacity) {
        //有意识的浪费一个空间 为（tail+1）%size做条件
        data = (E[]) new Object[capacity + 1];
        front = tail = 0;
    }

    public LoopQueue3() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            //队首元素不在0的位置[有front个偏移量]
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = getSize();
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        //此处去除size，没有size属性
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        //若tail >= front，则队列元素中的个数为tail - front
        if (tail >= front){
            return tail - front;
        }else{
            //若tail < front，此时元素中的队列个数为tail + data.length - front
            return tail + data.length - front;
        }
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d,capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue3<Integer> queue = new LoopQueue3<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }

        }
    }

}
