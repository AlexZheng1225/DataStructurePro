import java.util.Stack;

/**
 * @Author Alex Zheng
 * @Date 2021/2/14 20:02
 * @Annotation leetcode-20题
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                char topChar = stack.pop();
                if (c==')' && topChar!='('){
                    return false;
                }
                if (c==']' && topChar!='['){
                    return false;
                }
                if (c=='}' && topChar!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(){}[]";
        System.out.println(ValidParentheses.isValid(s));
    }

}
