class Solution {
    public int titleToNumber(String s) {
        if(s == null)
            return 0;
        
        int base = 1;
        int outPut = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            outPut += (s.charAt(i) - 'A' + 1) * base;
            base *= 26;
        }
        
        return outPut;
    }
}