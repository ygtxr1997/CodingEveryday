class Solution {
    private int[][][] dp;
    private int minPre(int m, int left, int right){
        int outPut = Integer.MAX_VALUE;
        for(int i = left + m - 1; i < right; i++){
            int tmp = Math.max(dp[m - 1][left][i], dp[0][i + 1][right]);
            if(tmp > outPut)
                break;
            else outPut = tmp;
        }

        return outPut;
    }
    public int splitArray(int[] nums, int m) {
        dp = new int[m][nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[0][i][i] = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                dp[0][i][j] = dp[0][i][j - 1] + nums[j];
            }
        }
        if(m == 1) return dp[m - 1][0][nums.length - 1];
        for(int i = 1; i < m - 1; i++){
            for(int j = 0; j < nums.length - i; j++){
                for(int k = j + i; k < nums.length; k++){
                    dp[i][j][k] = minPre(i, j, k);
                }
            }
        }
        return minPre(m - 1, 0, nums.length - 1);
    }
}