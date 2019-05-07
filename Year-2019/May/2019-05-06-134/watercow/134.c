class Solution {
public:
	int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
		int left = 0, run = 0, start = 0;

		for (int i = 0; i < gas.size(); i++) {
			run += gas[i] - cost[i];
			left += gas[i] - cost[i];

			if (run < 0) {
				run = 0;
				start = i + 1;
			}
		}

		return left < 0 ? -1 : start;
	}
};
