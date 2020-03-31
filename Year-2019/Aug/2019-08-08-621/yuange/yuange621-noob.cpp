class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int res = 0;
        map<char, int> mp; // <task, count>
        priority_queue<int> pq; // <count>,大根堆
        for (auto task : tasks) mp[task]++;
        if (mp.size() <= n + 1) { // 任务的种类小于等于每周期最多可执行的任务数
            int most = 0;
            for (auto ite : mp) if (ite.second > most) most = ite.second;
            for (auto ite : mp) if (ite.second == most) res++;
            return res + (most - 1) * (n + 1); 
        }
        for (auto ite : mp) pq.push(ite.second);
        while (pq.size() > n + 1) { // 剩余任务种类大于每周期可执行任务数
            vector<int> tmp;
            for (int i = 0; i < n + 1; ++i) {
                tmp.push_back(pq.top() - 1);
                pq.pop();
            }
            res += n + 1;
            for (int t : tmp) if (t > 0) pq.push(t);
        }
        int most = 0;
        while (!pq.empty()) {
            most = max(pq.top(), most);
            if (pq.top() == most) res++;
            pq.pop();
        }
        return res + (most - 1) * (n + 1);
    }
};