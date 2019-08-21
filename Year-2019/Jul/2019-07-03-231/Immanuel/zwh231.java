class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (Math.log10(n) / Math.log10(2)) % 1 == 0;
    }
}