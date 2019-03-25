/***
 *_______________#########_______________________
 *______________############_____________________
 *______________#############____________________
 *_____________##_############___________________
 *____________###__######_#####__________________
 *____________###_########__####_________________
 *___________###__##########_####________________
 *__________####__###########_####_______________
 *________#####___###########__#####_____________
 *_______######___###_########___#####___________
 *_______#####___###___########___######_________
 *______######___###__###########___######_______
 *_____######___####_##############__######______
 *____#######__#####################_#######_____
 *____#######__##############################____
 *___#######__######_#################_#######___
 *___#######__######_######_#########___######___
 *___#######____##__######___######_____######___
 *___#######________######____#####_____#####____
 *____######________#####_____#####_____####_____
 *_____#####________####______#####_____###______
 *______#####______;###________###______#________
 *________##_______####________####______________
 */
/*
 * @Author: yuange
 * @LastEditors: yuange
 * @Description: Coding everyday!
 * @Date: 2019-03-25 17:31:04
 * @LastEditTime: 2019-03-25 17:31:42
 */
// 维护一个size最大为n的优先队列
class Solution {
private:
    typedef struct Num {
        Num(int v, int r, int c) : val(v), row(r), col(c) {}
        int val; // 值
        int row; // 行
        int col; // 列
        bool operator < (const Num& n) const {
            return val > n.val;
        }
    } Num;
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int ret = 0;
        int n = matrix.size();
        priority_queue<Num> pq; // 初始size为n的优先队列
        for (int i = 0; i < n; ++i) pq.push(Num(matrix[i][0], i, 0));
        while (k--) {
            int row = pq.top().row;
            int col = pq.top().col + 1;
            ret = pq.top().val;
            pq.pop();
            if (col < n) pq.push(Num(matrix[row][col], row, col));
        }
        return ret;
    }
};