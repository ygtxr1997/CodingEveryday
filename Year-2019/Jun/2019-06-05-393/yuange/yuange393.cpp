// 12ms，95%
class Solution {
public:
    bool validUtf8(vector<int>& data) {
        unsigned char mask[5] = {0x80, 0xE0, 0xF0, 0xF8, 0xC0};
        unsigned char check[5] = {0x0, 0xC0, 0xE0, 0xF0, 0x80};
        for (int i = 0; i < data.size(); ) {
            unsigned char cur = data[i] & 0xFF;
            int j = 0;
            for (; j < 4; ++j) {
                if ((unsigned)((cur & mask[j]) ^ check[j]) == (unsigned)0) break;
            }
            if (j == 4) return false;
            i++;
            while (j > 0) {
                if (i >= data.size()) return false;
                cur = data[i] & 0xFF;
                if ((unsigned)((cur & mask[4]) ^ check[4]) != (unsigned)0) return false;
                i++;
                j--;
            }
        }
        return true;
    }
};