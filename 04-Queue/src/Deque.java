/**
 * @Author Alex Zheng
 * @Date 2021/2/14 21:23
 * @Annotation 双端队列的实现
 */
public class Deque<E>{

    private E[] data;
    private int front, tail;
    //Deque中的存储数量
    private int size;

    public Deque(int capacity) {
        data = (E[]) new Object[capacity]; //不浪费空间
        front = tail = 0;
        size = 0;
    }

    public Deque() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    //向Deque末端添加元素
    //相当于原先的enqueue
    public void addLast(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    //向Deque首端添加元素
    public void addFront(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        //首先要确定添加元素的位置
        //位置是在front-1的地方
        //如果front == 0，则新的位置应该为data.length - 1
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            //队首元素不在0的位置[有front个偏移量]
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    //向Deque首端取出元素
    //相当于原先的dequeue
    public E removeFront() {
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

    //向Deque尾端取出元素
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        //与addFront同理 新位置为tail - 1，若tail为0则tail = data.length - 1；
        tail = tail == 0 ? data.length - 1 : tail - 1;
        E ret = data[tail];
        //从队列中移除出元素
        data[tail] = null;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }


    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    //双端队列，也有一个从队尾获取元素的方法
    public E getLast() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        //在此处tail指向的是下一个元素的位置
        //需要进行计算才可得出tail的真实值
        int index = tail == 0 ? data.length - 1 : tail - 1;
        return data[index];
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return front == tail;
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
        // 在下面的双端队列的测试中，偶数从队尾加入；奇数从队首加入
        Deque<Integer> dq = new Deque<>();
        for(int i = 0 ; i < 16 ; i ++){
            if(i % 2 == 0){
                dq.addLast(i);
            }else{
                dq.addFront(i);
            }
            System.out.println(dq);
        }

        // 之后，我们依次从队首和队尾轮流删除元素
        System.out.println();
        for(int i = 0; !dq.isEmpty(); i ++){
            if(i % 2 == 0){
                dq.removeFront();
            }else{
                dq.removeLast();
            }
            System.out.println(dq);
        }

    }

}
