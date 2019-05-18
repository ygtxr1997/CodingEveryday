//递归求解，Runtime: 2 ms, faster than 76.83%
//统计s中各字母出现频数，若出现频数均大于k，返回s的长度
//在判断频数是否均大于k的同时，将不满足要求的字母作为分隔符存下来
//使用分隔符将s分割，对各子串进行递归处理
public class Solution{
    public int longestSubstring(String s, int k) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        Set<Character> separator = new HashSet<>();
        boolean flag = true;
        for(int i = 0; i < count.length; i++){
            if(count[i] != 0&& count[i] < k){
                flag = false;
                separator.add((char)(i + 'a'));
            }
        }
        if(flag)
            return s.length();

        int outPut = 0;
        int pre = 0;
        int post = 0;
        while (post < s.length()){
            char tmp = s.charAt(post);
            if(separator.contains(tmp)){
                outPut = Math.max(outPut, longestSubstring(s.substring(pre, post), k));
                pre = ++post;
            }
            else {
                post++;
            }
        }
        outPut = Math.max(outPut, longestSubstring(s.substring(pre, post), k));

        return outPut;
    }

}