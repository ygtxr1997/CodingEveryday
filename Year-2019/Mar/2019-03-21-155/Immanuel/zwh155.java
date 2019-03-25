import java.util.Arrays;

class MinStack {
    int min = Integer.MAX_VALUE;
    boolean flag = false;
    int incre = 10;
    int size = 100;
    int[] stack;
    int top = 0;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[size];
    }

    public void push(int x) {
        if(top >= size){
            stack = Arrays.copyOf(stack, size += incre);
        }

        stack[top++] = x;
        if(x < min){
            min = x;
            flag = true;
        }
    }

    public void pop() {
        top--;
        if(stack[top] == min){
            flag = false;
        }
    }

    public int top() {
        return stack[top - 1];
    }

    public int getMin() {
        if(flag)
            return min;
        else{
            min = Integer.MAX_VALUE;
            for(int i = 0; i < top; i++){
                min = Math.min(min, stack[i]);
            }
            flag = true;
            return min;
        }
    }
}
