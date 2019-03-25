// 使用最小堆完成
// 定义堆结构(正好复习一下)
class minheap {
private:
	int * data;
	int count;
	int capactity;

	void shiftUp(int k) {
		while (k > 1 && data[k / 2] > data[k]) {
			swap(data[k / 2], data[k]);
			k /= 2;
		}
	}

	void shiftDown(int k) {
		while (2 * k <= count) {
			int j = 2 * k;

			if (j + 1 <= count && data[j + 1] > data[j]) {
				j++;
			}

			if (data[k] >= data[j]) {
				break;
			}
			swap(data[k], data[j]);
			k = j;
		}
	}

public:
	minheap(int capacity) {
		data = new int[capacity + 1]; // 从index = 1开始
		count = 0;
		this->capactity = capactity;
	}

	minheap(vector<vector<int>>& arr, int m, int n) {
		data = new int[m * n + 1];
		
		capactity = m * n;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				data[i*j + 1] = arr[m][n];
			}
		}
		count = m * n;

		for (int i = count / 2; i >= 1; i--) {
			shiftDown(i);
		}
	}

	~minheap() {
		delete[] data;
	}

	int size() {
		return count;
	}

	bool isEmpty() {
		return count == 0;
	}

	void insert(int item) {
		assert(count + 1 <= capactity);

		data[count++ + 1] = item;
		shiftUp(count);
	}

	int poptop() {
		assert(count != 0);

		int res = data[1];

		data[1] = data[count--];
		shiftDown(1);
		return res;
	}

};

class Solution {
public:
	int kthSmallest(vector<vector<int>>& matrix, int k) {

		int m = matrix.size();
		int n = matrix[0].size();
		minheap heap = minheap(matrix, m, n);
		int number = 0;

		for (int i = 1; i <= k; i++) {
			number = heap.poptop();
		}
		return number;
	}
};