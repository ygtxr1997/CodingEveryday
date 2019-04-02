public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] outPut = new boolean[s.length() + 1];
        outPut[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(outPut[j]&& wordDict.contains(s.substring(j, i))){
                    outPut[i] = true;
                    break;
                }
            }
        }
        return outPut[s.length()];
    }
}
