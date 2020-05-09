/***
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * 单身狗就这样默默地看着你，一句话也不说。
 */

/**
 * @program: idea
 * @description: x的平方根
 * @author: Lovely Dragon
 * @create: 2020-05-09 18:01
 */
public class MySqrt {
    //二分查找
    public int mySqrt(int x) {
        int result = get(0,x,x);
        if (result * result > x)
            return result-1;
        return result;
    }


    public int get(int left,int right,int x){
        if (left >= right)
            return left;
        long mid = left + (right-left)/2;
        if (mid * mid == x)
            return (int)mid;
        //存在溢出的情况
        if (mid * mid  > x)
            return get(left,(int)mid-1,x);
        else
            return get((int)mid+1,right,x);
    }
}
