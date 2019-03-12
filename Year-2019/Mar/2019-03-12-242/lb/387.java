class Solution {
    public int firstUniqChar(String s) {
        int[] si = new int[26];
        char[] sc = s.toCharArray();
        for (char c : sc){
            si[c-'a'] ++;
        }
        for (int i = 0;i<sc.length;i++){
            if (si[sc[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
