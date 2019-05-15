public class Solution{
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";

        StringBuilder outPut = new StringBuilder();
        if((numerator < 0)^ (denominator < 0)){
            outPut.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        //整数部分
        outPut.append(num / den);
        num %= den;
        if(num == 0)
            return outPut.toString();

        //小数部分
        outPut.append('.');
        //通过查看是否出现相同余数的方式判断有无循环节
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, outPut.length());
        while (num != 0){
            num *= 10;
            outPut.append(num / den);
            num %= den;
            if(map.containsKey(num)){
                int index = map.get(num);
                outPut.insert(index, "(").append(")");
                break;
            }
            else {
                map.put(num, outPut.length());
            }
        }

        return outPut.toString();
    }
}