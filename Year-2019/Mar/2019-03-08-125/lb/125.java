class Solution {
//双指针查询
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] sc = s.toCharArray();
        int length = s.length()-1;
        for (int i=0;i<length;){
        //忽略除符号数字以外的所有字符
            if ((sc[i]<'a' || sc[i]>'z' ) && (sc[i]<'0' || sc[i]>'9')){
                i++;
                continue;
            }
            if((sc[length]<'a' || sc[length]>'z') && (sc[length]<'0' || sc[length]>'9')){
                length--;
                continue;
            }
            if (sc[i] != sc[length])
                return false;
            i++;
            length--;
        }
        return true;
    }
}
