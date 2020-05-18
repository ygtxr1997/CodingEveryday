class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        visited.resize(numCourses);
        table.resize(numCourses);
        for (auto v : prerequisites) table[v[1]].insert(v[0]);
        for (int i = 0; i < numCourses; ++i) dfs(i);
        return hasCircle ? vector<int>() : vector<int>(ans.rbegin(), ans.rend());
    }
    
    void dfs(int cur) {
        if (visited[cur] == 1) ;
        else if (visited[cur] == 2) hasCircle = true;
        else if (table[cur].empty()) {
            ans.push_back(cur); // 叶子节点
            visited[cur] = 1;
        } else {
            visited[cur] = 2;
            for (auto son : table[cur]) dfs(son);
            ans.push_back(cur);
            visited[cur] = 1;
        }
    }
private:
    vector<unordered_set<int>> table;   // 存储子节点集合
    vector<int> visited;                // 访问状态，0:未被访问，1:已被访问，2:正在访问
    bool hasCircle;                     // 是否有环
    vector<int> ans;                    // 上课顺序
};