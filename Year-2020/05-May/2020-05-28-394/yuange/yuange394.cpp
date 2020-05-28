class Solution {
public:
    unordered_map<int, int> hash; // <left, right>
    string decode(string& str, int l, int r) {
        string ret;
        int i = l;
        while (i <= r) {
            if (str[i] >= 'a' && str[i] <= 'z' || str[i] >= 'A' && str[i] <= 'Z') {
                ret.push_back(str[i]);
                i++;
            } else if (str[i] >= '0' && str[i] <= '9') {
                int j = i, num = 0;
                while (j <= r && str[j] >= '0' && str[j] <= '9') {
                    num *= 10;
                    num += str[j] - '0';
                    j++;
                }
                string ss = decode(str, j + 1, hash[j] - 1);
                for (int k = 0; k < num; ++k) ret.append(ss);
                i = hash[j] + 1;
            }
        }
        return ret;
    }
    string decodeString(string s) {
        // 括号匹配
        stack<int> st;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == '[') st.push(i);
            else if (s[i] == ']') {
                int left = st.top();
                st.pop();
                hash[left] = i;
            }
        }
        return decode(s, 0, s.size() - 1);
    }
};