class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0? true: false;

        long xL = Math.abs((long)x);
        long output = 0;
        while (xL > 0){
            output *= 10;
            output += (xL % 10);
            xL /= 10;
        }

        return output > Integer.MAX_VALUE? 0: isNegative? (int) (0 - output): (int)output;
    }
}