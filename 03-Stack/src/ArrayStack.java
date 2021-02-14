/**
 * @Author Alex Zheng
 * @Date 2021/2/14 17:38
 * @Annotation
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    //获取栈的容量
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    //看一眼栈顶元素
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ArrayStack{");
        sb.append("[");
        sb.append(array).append("--> Top");
        sb.append("]");
        sb.append('}');
        return sb.toString();
    }
}
