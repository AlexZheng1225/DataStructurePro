/**
 * @Author Alex Zheng
 * @Date 2021/2/13 15:16
 * @Annotation
 */
public class Array<E> { //添加一个<E> 表示存放一个数据类型

    private E[] data;
    private int size;

    //构造参数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity]; //需要这样实现泛型
        size = 0;
    }

    //无参构造函数，默认数组容量capacity为10
    public Array() {
        this(10);
    }

    //获取数组中元素的个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向数组末尾添加元素e
    public void addLast(E e) {
//        //判断一下数组空间是否能容器新加入的元素
//        if (size==data.length){
//            throw new IllegalArgumentException("AddLast Failed,array is full");
//        }
//        data[size] = e;
//        size++;
        add(size,e);
    }

    //向数组头部添加元素e
    public void addFirst(E e){
        add(0,e);
    }

    //向数组中index位置添加元素e
    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add Failed,array require index >=0 or ibdex <= size");
        }

        //扩容
        if (size == data.length) {
            resize(data.length * 2);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //获取index索引位置的元素值e
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get is faild. Index is illegal.");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    //修改index索引位置的元素值e
    public void set(int index,E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set is faild. Index is illegal.");
        }
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contanis(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找元素e的索引，查找到则返回索引值index 否则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //从数组中删除元素[传入下标]
    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove is faild. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        //防止对象游离 != 内存泄漏
        data[size] = null;

        //缩容
        if (size == data.length / 4 && data.length / 2 != 0) { //防止复杂度震荡
            resize(data.length / 2);
        }

        return ret;
    }

    //删除数组的第一个元素
    public E removeFirst(){
        return remove(0);
    }

    //删除数组的最后一个元素
    public E removeLast(){
        return remove(size-1);
    }

    //从数组中删除元素e （并不保证删除所有元素e 因为元素e可能不止一个 find函数同理）
    public void removeElement(E e){
        int index = find(e);
        if(index!=-1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("array:size = %d,capacity = %d\n", size, data.length));
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
