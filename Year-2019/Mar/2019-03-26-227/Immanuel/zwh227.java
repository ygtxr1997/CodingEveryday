public class Solution {
   public int calculate(String s) {
       //类似于处理耦合，将高优先级的运算符解决掉，最后仅剩加减操作
       int len;
       if(s==null || (len = s.length())==0) return 0;
       Stack<Integer> stack = new Stack<Integer>();
       int num = 0;
       char sign = '+';
       for(int i=0;i<len;i++){
           if(Character.isDigit(s.charAt(i))){
               num = num*10+s.charAt(i)-'0';
           }
           if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
               if(sign=='-'){
                   stack.push(-num);
               }
               if(sign=='+'){
                   stack.push(num);
               }
               if(sign=='*'){
                   stack.push(stack.pop()*num);
               }
               if(sign=='/'){
                   stack.push(stack.pop()/num);
               }
               sign = s.charAt(i);
               num = 0;
           }
       }

       int re = 0;
       for(int i:stack){
           re += i;
       }
       return re;
   }

     // private int solve(int operand2, int operand1, char operator){
     //     switch (operator){
     //         case '+':
     //             return operand1 + operand2;
     //         case '-':
     //             return operand1 - operand2;
     //         case '*':
     //             return operand1 * operand2;
     //         default:
     //             return operand1 / operand2;
     //     }
     // }

//      public int calculate(String s) {
//          Queue<Character> operatorTmp = new LinkedList<>();
//          StringBuilder inPut = new StringBuilder();
//          for(int i = 0; i < s.length(); i++){
//              char tmp = s.charAt(i);
//              if(tmp != ' '){
//                  inPut.append(tmp);
//                  if(tmp == '+'|| tmp == '-'|| tmp == '*'|| tmp == '/'){
//                      operatorTmp.offer(tmp);
//                  }
//              }
//          }

//          String[] operandTmp = inPut.toString().split("\\+|-|\\*|/");
//          if(operandTmp.length == 1){
//              return Integer.parseInt(operandTmp[0]);
//          }

//          int  operandPre = Integer.parseInt(operandTmp[0]);
//          int  operandCur = Integer.parseInt(operandTmp[1]);
//          char operatorPre = operatorTmp.poll();
//          int count = 2;

//          while (!operatorTmp.isEmpty()){
//              if((operatorPre == '+'|| operatorPre == '-')&& (operatorTmp.peek() == '*'|| operatorTmp.peek() == '/')){
//                  operandCur = solve(Integer.parseInt(operandTmp[count++]), operandCur, operatorTmp.poll());
//              }
//              else {
//                  operandPre = solve(operandCur, operandPre, operatorPre);
//                  operandCur = Integer.parseInt(operandTmp[count++]);
//                  operatorPre = operatorTmp.poll();
//              }
//          }



//          return solve(operandCur, operandPre, operatorPre);
//      }
}