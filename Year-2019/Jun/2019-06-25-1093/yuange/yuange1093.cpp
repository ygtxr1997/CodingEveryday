class Solution {
public:
    vector<double> sampleStats(vector<int>& count) {
        vector<double> ret(5, -1);
        long sum = 0, num = 0;
        int most = 0;
        for (int i = 0; i < 256; ++i) {
            if (count[i] != 0 && ret[0] == -1) ret[0] = i;
            if (count[i] != 0 && i > ret[1]) ret[1] = i;
            sum += i * count[i];
            num += count[i];
            if (count[i] > most) {
                most = count[i];
                ret[4] = i;
            }
        }
        ret[2] = ((double)sum) / num;
        int l = -1, r = -1, k = 0;
        for (int i = 0; i < 256; ++i) {
            k += count[i];
            if (k >= (num - 1 ) / 2 + 1 && l == -1) l = i;
            if (k >= num / 2 + 1 && r == -1) r = i;
        }
        ret[3] = 0.5 * (l + r);
        return ret;
    }
};