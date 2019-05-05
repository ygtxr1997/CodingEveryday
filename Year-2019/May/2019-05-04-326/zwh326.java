class Solution {
    // public boolean isPowerOfThree(int n) {
    //     return ( n > 0&&  1162261467 % n == 0);
    // }
    // public boolean isPowerOfThree(int n) {
    //     return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    // }
    static HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467));
    public boolean isPowerOfThree(int n) { 
        return set.contains(n);
    }
}