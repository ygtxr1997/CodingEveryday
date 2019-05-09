public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        String tmp = Integer.valueOf(x).toString();
        
        int i = 0;
        int j = tmp.length() - 1;
        while (i < j){
            if(tmp.charAt(i++) != tmp.charAt(j--)) {
                return false;
            }
        }
        
        return true;
    }
}