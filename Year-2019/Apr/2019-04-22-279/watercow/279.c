// 使用BFS：
// 将问题转化为图问题:
// 从n到0， 每个数字表示一个节点
// 如果两个数字x到y相差一个完全平方数，则两个节点连一条边
// 最后可以得到一个无权图
// 原问题变为，求无权图 n->0 的最短路径
// 所以使用queue进行BFS操作
class Solution {
public:
    int numSquares(int n) {
        // 第一个int表示节点，第二个表示当前step数
        queue< pair<int, int> > q;
        q.push(make_pair(n, 0));

        vector<bool> isvisited(n + 1, false);
        isvisited[n] = true;

        while( !q.empty() ) {
            int node = q.front().first;
            int step = q.front().second;
            q.pop();
            
            for(int i = 0; ; i++) {
                int a = node - i*i;

                if (a < 0) break;
                if (a == 0) return step + 1; // 下一步就可以到达节点0

                if ( !isvisited[a] ) {
                    q.push(make_pair(a, step+1));
                }
            }
        }

        return -1; // 输入数字不合法
    }
};
