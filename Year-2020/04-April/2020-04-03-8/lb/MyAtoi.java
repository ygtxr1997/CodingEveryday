package com.company;

public class MyAtoi {
    //字符串转换整数
    //超出数值范围
    //超出数据类型所能表示的值的范围
    public int myAtoi(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean symbol = true;
        boolean number = false;
        boolean space = true;
        for (char c : str.toCharArray()){
            if (c == ' ' && space)
                continue;
            if (symbol && c == '+'){
                space = false;
                symbol = false;
                continue;
            }
            if (symbol && c == '-'){
                space = false;
                symbol = false;
                stringBuilder.append('-');
                continue;
            }
            if ( c >= '0' && c<= '9'){
                space = false;
                symbol = false;
                number = true;
                stringBuilder.append(c);
            }else
                break;
        }
        str = stringBuilder.toString();
        int result = 0;
        if (str.equals("") || !number)
            return 0;
        try {
            //这里还是存在溢出的情况
            result = Integer.parseInt(str);
        }catch (NumberFormatException e){
            if(stringBuilder.charAt(0) == '-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
        if (stringBuilder.charAt(0) == '-' && result > 0)
            return Integer.MIN_VALUE;
        if (stringBuilder.charAt(0) != '-' && result < 0)
            return Integer.MAX_VALUE;
        return result;
    }
}
