class Solution {
public:
    bool isPalindrome(const string& str) {
        if (str.size() <= 1) return true;
        int i = 0, j = str.size() - 1;
        while (i < j) {
            if (str[i] != str[j]) return false;
            i++, j--;
        }
        return true;
    }
    bool validPalindrome(string s) {
        if (s.size() <= 2) return true;
        int i = 0, j = s.size() - 1;
        while (i < j) {
            if (s[i] != s[j]) 
                return isPalindrome(s.substr(i, j - i))
                    || isPalindrome(s.substr(i + 1, j - i));
            i++, j--;
        }
        return true;
    }
};