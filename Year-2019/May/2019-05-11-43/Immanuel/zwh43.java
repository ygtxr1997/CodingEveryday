public class Solution {
    private StringBuilder add(StringBuilder num1, StringBuilder num2){
        StringBuilder outPut = new StringBuilder();
        int carry = 0;
        int pos = 0;
        while (pos < num1.length()&& pos < num2.length()){
            int sum = (num1.charAt(pos) - '0') + (num2.charAt(pos) - '0') + carry;
            outPut.append(sum % 10);
            carry = sum / 10;
            pos++;
        }
        while(pos < num1.length()){
            int sum = (num1.charAt(pos) - '0') + carry;
            outPut.append(sum % 10);
            carry = sum / 10;
            pos++;
        }
        while(pos < num2.length()){
            int sum = (num2.charAt(pos) - '0') + carry;
            outPut.append(sum % 10);
            carry = sum / 10;
            pos++;
        }
        if(carry != 0){
            outPut.append(carry);
        }

        return outPut;
    }

    public String multiply(String num1, String num2) {
        StringBuilder outPut = new StringBuilder();

        for(int i = num1.length() - 1; i >= 0; i--){
            int digit1 = num1.charAt(i) - '0';
            StringBuilder tmp = new StringBuilder();
            for(int j = num1.length() - 1; j > i; j--){
                tmp.append(0);
            }
            int carry = 0;
            int digit2;
            for(int j = num2.length() - 1; j >= 0; j--){
                digit2 = num2.charAt(j) - '0';
                digit2 = digit1 * digit2 + carry;
                tmp.append(digit2 % 10);
                carry = digit2 / 10;
            }
            if(carry != 0){
                tmp.append(carry);
            }

            outPut = add(outPut, tmp);
        }
        int begin = outPut.length();
        while (begin > 1&& outPut.charAt(begin - 1) == '0'){
            begin--;
        }
        outPut.delete(begin, outPut.length());

        return outPut.reverse().toString();
    }
}