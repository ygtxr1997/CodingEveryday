class Solution {
//manacher法
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2)
            return s;
        
        StringBuilder newS = new StringBuilder();
        newS.append("#");
        for (int i = 0; i < len; i++) {
            newS.append(s.charAt(i));
            newS.append("#");
        }
        int[] p= new int[newS.length()];

        p[0] = 1;
        int max = 0;
        int posMax = 0;
        int rightMax = 1;
        for(int i = 1; i < p.length; i++){
            p[i] = rightMax > i? Math.min(rightMax - i, p[2 * posMax - i]): 1;
            while (i - p[i] >= 0&& i + p[i] < newS.length()&& newS.charAt(i - p[i]) == newS.charAt(i + p[i])){
                p[i]++;
            }
            if(i + p[i] > rightMax){
                rightMax = i + p[i];
                posMax = i;    
            }
            if(p[i] > p[max])
                max = i;
        }
        
        return newS.substring(max - p[max] + 1, max + p[max]).replace("#", "");
    }
    
// 动态规划法
//     public String longestPalindrome(String s) {
//         int len = s.length();
//         if(len < 2)
//             return s;

//         boolean[][] ispalindrome = new boolean[len][len];
//         for(int i = 0; i < len - 1; i++){
//             ispalindrome[i][i] = true;
//             ispalindrome[i + 1][i] = true;
//         }
//         ispalindrome[len - 1][len - 1] = true;

//         int lenMax = 1;
//         int start = 0;
//         for(int i = len - 2; i >= 0; i--){
//             for(int j = i + 1; j < len; j++){
//                 if(s.charAt(i) == s.charAt(j)&& ispalindrome[i + 1][j - 1]){
//                     ispalindrome[i][j] = true;
//                     if(j - i >= lenMax){
//                         lenMax = j - i + 1;
//                         start = i;
//                     }
//                 }
//             }
//         }

//         return s.substring(start, start + lenMax);
//     }
    
  
// //中心扩散法，注意递归写法比迭代写法运行速度要快
//     private int lenMax;
//     private int pos;
//     private int len;
    
//     private void extendPalindrome(String s, int left, int right){
//         while (left >= 0&& right < len&& s.charAt(left) == s.charAt(right)){
//             left--;
//             right++;
//         }
//         if(right - left - 1> lenMax){
//             lenMax = right - left - 1;
//             pos = left + 1;
//         }
//     }
    
//     public String longestPalindrome(String s) {
//         len = s.length();
//         if(len < 2)
//             return s;

//         for(int i = 1; i < len; i++){
//             extendPalindrome(s, i, i);
//      	    extendPalindrome(s, i - 1, i); 
//         }
        
//         return s.substring(pos, pos + lenMax);   
//     }
    
}