/**
 * @Author Alex Zheng
 * @Date 2021/2/14 21:23
 * @Annotation 利用size实现不浪费一个空间的循环队列
 */
public class LoopQueue2<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue2(int capacity) {
        //因为不需要浪费一个空间 capacity需要修改
        data = (E[]) new Object[capacity];
        front = tail = 0;
        size = 0;
    }

    public LoopQueue2() {
        this(10);
    }

    public int getCapacity() {
        //此处也不需要-1
        return data.length;
    }

    @Override
    public void enqueue(E e) {
        //直接利用size与容量的比较决定是否扩容
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            //队首元素不在0的位置[有front个偏移量]
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        //不再利用front和tail的关系判断队列是否为空，直接使用size
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d,capacity = %d\n", size, getCapacity()));
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
        LoopQueue2<Integer> queue = new LoopQueue2<>();
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
