class Solution {
private:
    int dic[8][2] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
public:
    // 获得第(i,j)个细胞周围的活细胞数量
    int getLive(vector<vector<int>>& board, int i, int j) {
        int ans = 0;
        for (int op = 0; op < 8; ++op) {
            int ii = i + dic[op][0];
            int jj = j + dic[op][1];
            if (ii >= 0 && ii < board.size() && jj >= 0 && jj < board[0].size() && board[ii][jj] % 2 > 0) ans++; 
        }
        return ans;
    }
    
    void gameOfLife(vector<vector<int>>& board) {
        int n = board.size(), m = board[0].size();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                // 最后一位用来保存该位初始状态，前面的位用来保存周围的活细胞数量
                board[i][j] = (getLive(board, i, j) << 1) + board[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] % 2 == 0) board[i][j] = (board[i][j] / 2 == 3 ? 1 : 0);
                else board[i][j] = (board[i][j] / 2 == 2 || board[i][j] / 2 == 3) ? 1 : 0;
            }
        }
    }
};