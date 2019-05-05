public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int outPut = 0;
        for(int i = 0; i < 16; i++){
            int tmp = 1 << i;
            tmp &= n;
            tmp <<= (31 - 2 * i);
            outPut += tmp;
        }
        for(int i = 0; i < 16; i++){
            int tmp = 1 << (i + 16);
            tmp &= n;
            tmp >>>= (1 + 2 * i);
            outPut += tmp;
        }
        
        return outPut;
    }
}