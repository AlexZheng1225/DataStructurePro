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

}
