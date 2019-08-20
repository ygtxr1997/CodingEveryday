class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() == 0)
            return 0;

        //确定符号
        int index = 0;
        boolean isNegative = false;
        if(str.charAt(index) == '-' || str.charAt(index) == '+'){
            isNegative = str.charAt(index) == '-'? true: false;
            index++;
        }

        long result = 0;
        while (index < str.length()){
            int tmp = str.charAt(index++) - '0';
            if(tmp <= 9 && tmp >= 0){
                result = result * 10 + tmp;
                if(result > Integer.MAX_VALUE){//判断是否发生溢出
                    return isNegative? Integer.MIN_VALUE: Integer.MAX_VALUE;
                }
            }
            else{
                break;
            }
        }

        return isNegative? (int)(0 - result): (int)result;
    }
}