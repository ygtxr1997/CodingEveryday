// 124ms, 34%
// BFS，转化为图论问题，使用广度优先搜索
// 但是写代码时不需要实际生成树，而是直接借助队列BFS
class Solution {
public:
    int numSquares(int n) {
        queue<pair<int, int>> q;
        q.push(make_pair(n, 0));
        unordered_set<int> visited;     // 相当于剪枝，如果后面有新出现的相同值，
        // 那么新值step一定大于旧值的step
        while (!q.empty()) {
            int val = q.front().first;
            int step = q.front().second;
            for (int i = 1, son = 0; son >= 0; ++i) {
                son = val - i * i;
                if (0 == son) return step + 1;
                else if (!visited.count(son)) {
                    q.push(make_pair(son, step + 1));
                    visited.insert(son);
                }
            }
            q.pop();
        }
        return 1;
    }
};
