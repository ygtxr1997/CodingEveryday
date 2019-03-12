class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc =  s.toCharArray();
        char[] tc = t.toCharArray();
        if (sc.length!=tc.length){
            return false;
        }
        int[] si = new int[26];
        int[] ti = new int[26];
        for(int i=0;i<sc.length;i++){
            si[sc[i] - 'a'] ++;
            ti[tc[i] - 'a'] ++;
        }
        for (int i = 0;i<26;i++){
            if (si[i] != ti[i])
                return false;
        }
        return true;
    }
}
