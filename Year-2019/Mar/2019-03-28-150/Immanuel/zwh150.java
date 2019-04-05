class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operand = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            switch (tokens[i]) {
                case "+":
                    operand.push(operand.pop() + operand.pop());
                    break;
                case "-":
                    operand.push(-operand.pop() + operand.pop());
                    break;
                case "*":
                    operand.push(operand.pop() * operand.pop());
                    break;
                case "/":
                    int operand2 = operand.pop();
                    int operand1 = operand.pop();
                    operand.push(operand1 / operand2);
                    break;
                default:
                    operand.push(Integer.parseInt(tokens[i]));
                
            }
            
        }

        return operand.pop();
    }
}