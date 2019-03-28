class Solution {
     private int N =-1;
    /**
     * 使用递归的方式从最内层开始计算
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {

        if(N==-1)
            N=tokens.length-1;
        String s = tokens[N--];
        char c = s.charAt(0);
        //存在负数的情况，导致c为-而出错
        if(s.equals("-") || "+*/".indexOf(c)!=-1){
//        if(s.length() == 1 && "+-*/".indexOf(c)!=-1){
            int a = evalRPN(tokens);
            int b = evalRPN(tokens);
            switch(c){
                case '+':return a+b;
                case '-':return b-a;
                case '*':return a*b;
                case '/':return b/a;
                default:break;
            }
        }
        return Integer.parseInt(s);
    }
}
