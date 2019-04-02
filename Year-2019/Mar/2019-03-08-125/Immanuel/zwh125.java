class Solution {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        Set<Character> letters = new HashSet();
        for(int i = 0; i < 26; i++){
            letters.add((char)('a' + i));
        }
        for(int i = 0; i < 10; i++){
            letters.add((char)('0' + i));
        }
        while(left <= right){
            if(!letters.contains(s.charAt(left)))
                left++;
            else if(!letters.contains(s.charAt(right)))
                right--;
            else if(s.charAt(left) != s.charAt(right))
                return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}