// DFS + 记录最大值
// WDNMD 打错字调了5mins ???
class Solution {
public:
	int maxAreaOfIsland(vector<vector<int>>& grid) {
		
		if (grid.size() == 0) return 0;
		if (grid[0].size() == 0) return 0;

		int ret = 0;

		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid[0].size(); j++) {
				res = 0;
				dfs(grid, i, j);
				ret = max(res, ret);
			}
		}

		return ret;
 	}

	// i 横坐标 j 纵坐标
	void dfs(vector<vector<int>>& grid, int i, int j) {
		if (i < 0 || i >= grid.size()) return;
		if (j < 0 || j >= grid[0].size()) return;
		if (grid[i][j] == 0) return;

		res++;
		grid[i][j] = 0;
		
		// dfs四个方向
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}

private:
	int res = 0;
};
