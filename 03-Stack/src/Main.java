/**
 * @Author Alex Zheng
 * @Date 2021/2/14 17:50
 * @Annotation
 */
public class Main {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
    }

}
