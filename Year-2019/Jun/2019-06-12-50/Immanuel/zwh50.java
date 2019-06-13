public class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        x = n > 0? x: 1.0 / x;
        double tmp = myPow(x, Math.abs(n / 2));

        return tmp * tmp * (n % 2 == 0? 1.0: x);
    }
}