// bfs，借助队列搜素，72ms，85%
// 对于“两个单词之间是否只差一个字母”，可以借助h_g模式匹配
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        int n = wordList.size(), m = wordList[0].length();
        unordered_map<string, unordered_set<int>> dic;      // 辅助字典，key:带_的字符串，val:符合key模式的字母序号集合
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                string key = wordList[i];
                key[j] = '_';
                dic[key].insert(i);
            }
        }
        queue<pair<int, int>> bfs;          // bfs的队列
        vector<bool> visited(n);            // 元素是否访问过
        bfs.push(make_pair(-1, 1));         // beginWord入队列
        while(!bfs.empty()) {
            string cur = bfs.front().first < 0 ? beginWord : wordList[bfs.front().first];
            int step = bfs.front().second;
            for (int j = 0; j < m; ++j) {
                char c = cur[j];
                cur[j] = '_';
                auto ite = dic.find(cur);   // 查找符合当前模式的所有字母序号集合
                if (ite != dic.end()) {
                    for (auto index : ite->second) {
                        if (!visited[index]) {
                            visited[index] = 1;
                            if (wordList[index] == endWord) return step + 1;
                            bfs.push(make_pair(index, step + 1));
                        }
                    }
                }
                cur[j] = c;
            }
            bfs.pop();
        }
        return 0;
    }
};
