import java.util.Stack;

public class EvalRPN {
    /**
     * 使用栈的一般解
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int m;
        int n;
        for (String str : tokens){
            if ("+".equals(str)){
                m = Integer.parseInt(stack.pop());
                n = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(m+n));
            }else if("-".equals(str)){
                m = Integer.parseInt(stack.pop());
                n = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(n-m));
            }else if ("*".equals(str)){
                m = Integer.parseInt(stack.pop());
                n = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(n*m));
            }else if ("/".equals(str)){
                m = Integer.parseInt(stack.pop());
                n = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(n/m));
            }else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
