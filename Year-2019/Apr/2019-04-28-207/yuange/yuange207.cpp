// 16ms,98%
// bfs，深度优先搜索的访问结果恰好是拓扑排序的逆序列
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        visited.resize(numCourses);
        table.resize(numCourses);
        for (auto v : prerequisites) table[v[1]].insert(v[0]);
        for (int i = 0; i < numCourses; ++i) dfs(i);
        return !hasCircle;
    }
    
    // 返回 true 时代表有环
    void dfs(int cur) {
        visited[cur] = 2;           // 加入正在访问的序列
        for (auto son : table[cur]) {
            if (visited[son] == 0) dfs(son);
            else if (visited[son] == 2) {
                hasCircle = true;
                return;        // 有环
            }
        }
        visited[cur] = 1;           // 访问完毕
    }
private:
    bool hasCircle = false;
    vector<int> visited;    // 0:未被访问，1:已被访问，2:正在访问
    vector<unordered_set<int>> table;   // 邻接矩阵，set为子节点的集合
};
