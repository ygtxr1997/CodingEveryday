class Solution {
    //牛批
    // public boolean isPalindrome(int x) {
    //     if (x<0 || (x!=0 && x%10==0)) return false;
    //     int rev = 0;
    //     while (x>rev){
    //         rev = rev*10 + x%10;
    //         x = x/10;
    //     }
    //     return (x==rev || x==rev/10);
    // }
    
    private int reverse(int x) {
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
    
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        return x == reverse(x);
    }
}