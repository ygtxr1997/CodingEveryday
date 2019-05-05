public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int tmp = 1;
        for(int i = 0; i < 32; i++){
            if((n & tmp) != 0){
                count++;
            }
            tmp <<= 1;
        }
        return count;
    }
}