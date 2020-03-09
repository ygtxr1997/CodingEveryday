// 贪心，40ms，67%
class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int num_wanted, int use_limit) {
        multimap<int, int> dic; // <value, label>
        map<int, int> hash; // <label, count>
        int ret = 0;
        int n = values.size();
        for (int i = 0; i < n; ++i) {
            dic.insert(make_pair(-values[i], labels[i]));
        }
        auto ite = dic.begin();
        while (num_wanted && ite != dic.end()) {
            int value = ite->first, label = ite->second;
            if (hash[label] < use_limit) {
                ret += ite->first;
                hash[label]++;
                num_wanted--;
            }
            ite++;
        }
        
        return -ret;
    }
};