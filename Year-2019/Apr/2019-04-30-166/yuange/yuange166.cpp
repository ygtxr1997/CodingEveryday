// 处理各种特殊情况的开销远大于算法本身,给个差评，0ms，100%
class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        string result;
        if(denominator == 0) return result;
        //处理符号
        if((numerator < 0 && denominator > 0)
           || (numerator > 0 && denominator < 0)) result += "-";
        long long num = static_cast<long long>(numerator);
        long long denom = static_cast<long long>(denominator);
        num = abs(num);
        denom = abs(denom);
        //处理整数部分
        result += to_string(num / denom);
        num %= denom;
        //处理小数部分
        if(num) result += ".";
        //利用hash表记录出现过的除数从而定位循环
        unordered_map<long long, int> map;
        int index = 0;//当前index - map[num]可以定位循环的长度
        while(num && map.count(num) == 0) {
            map[num] = result.length();
            num *= 10;
            result += to_string(num / denom);
            num %= denom;
        }
        //如果是出现了循环小数
        if(map.count(num) != 0) {
            result += ")";
            result.insert(map[num], "(");
        }
        return result;
    }
};
