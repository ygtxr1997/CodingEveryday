class Solution {
    /**
     * 根据输入字符的长度来进行动态规划dp
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        for (int i=1;i<=length;i++){
            //直接包含有直接为true，可并入下面的判断条件中，只需声明dp[0]为true即可
            if (wordDict.contains(s.substring(0,i))){
                dp[i] = true;
                continue;
            }
            for (int j = 1; j<i ; j++){
                if (dp[j]){
                    //dp[i] = dp[j] + i-j之间的字符串是否在字典里面
                    if (wordDict.contains(s.substring(j,i))){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[length];
    }
}
