/**
 * @Author Alex Zheng
 * @Date 2021/2/13 15:16
 * @Annotation
 */
public class Array {

    private int[] data;
    private int size;

    //构造参数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
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
    public void addLast(int e) {
//        //判断一下数组空间是否能容器新加入的元素
//        if (size==data.length){
//            throw new IllegalArgumentException("AddLast Failed,array is full");
//        }
//        data[size] = e;
//        size++;
        add(size,e);
    }

    //向数组头部添加元素e
    public void addFirst(int e){
        add(0,e);
    }

    //向数组中index位置添加元素e
    public void add(int index,int e){
        if (size==data.length){
            throw new IllegalArgumentException("Add Failed,array is full");
        }

        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add Failed,array require index >=0 or ibdex <= size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

}
