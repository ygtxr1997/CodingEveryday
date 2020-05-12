package com.company;

public class MyPow {
    //Pow(x,n)
    //当n为偶数时，递归上一个值的平方
    //当n为奇数时，额外乘上一个x的值
    public double myPow(double x, int n) {
        double res = 1;
        //n =   9  4  2  1
        //res = x  x  x  x9
        //x =   x2 x4 x8 x16
        for (int i = n; i !=0 ; i/=2) {
            if (i%2 == 1){
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1/res : res;
    }
}
