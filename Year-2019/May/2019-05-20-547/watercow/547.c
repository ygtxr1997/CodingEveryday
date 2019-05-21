// 用并查集
// 需要复现一个并查集
class Solution {
public:
	int findCircleNum(vector<vector<int>>& M) {
		if (M.size() == 0) return 0;
		
		int row_size = M.size();
		int col_size = M[0].size();
		UnionFind(row_size);

		for (int i = 0; i < row_size; i++) {
			for (int j = i + 1; j < col_size; j++) {
				if (M[i][j]) UnionElement(i, j);
			}
		}

		return numberOfID();
	}

private:
	int count;
	vector<int> id;

public:
	void UnionFind(int n) {
		count = n;
		vector<int> a(n, 0);

		for (int i = 0; i < n; i++) {
			a[i] = i;
		}

		id = a;
	}

	int find(int p) {

		return id[p];
	}

	bool isConnected(int p, int q) {

		return find(p) == find(q);
	}

	void UnionElement(int p, int q) {

		int pID = find(p);
		int qID = find(q);

		if (pID == qID)
			return;

		for (int i = 0; i < count; i++) {
			if (id[i] == pID) {
				id[i] = qID;
			}
		}
	}

	int numberOfID() {
		int ret = 0;
		vector<int> cnt(count, 0);
		for (int i = 0; i < count; i++) {
			cnt[id[i]]++;
		}

		for (auto i : cnt) {
			if (i > 0)
				ret++;
		}

		return ret;
	}
};
