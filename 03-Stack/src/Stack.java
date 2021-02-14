/**
 * @Author Alex Zheng
 * @Date 2021/2/14 17:38
 * @Annotation
 */
public interface Stack<E> {

    int getSize();  //获取栈中元素数量
    boolean isEmpty();  //判断栈是否为空
    void push(E e);  //进栈
    E pop();  //出栈
    E peek();  //查看栈顶元素

}
