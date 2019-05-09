public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] dp = new int[s.length()];

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < dp.length; i++){
            dp[i] = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
        }

        int outPut = Integer.MIN_VALUE;
        int begin = 0;
        int count = 0;
        for(int i = 0; i < dp.length; i++){//可以与上面的遍历合并
            if(dp[i] < begin){
                count++;
            }
            else{
                outPut = Math.max(outPut, count);
                begin = dp[i] + 1;
                count = i - dp[i];
            }
        }
        outPut = Math.max(outPut, count);

        return outPut;
    }
}