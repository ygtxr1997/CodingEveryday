class Solution {
public:
	vector<double> sampleStats(vector<int>& count) {
		double MAX = 0, MIN = 256, AVE, MED, MOD, total = 0;
		int totalcnt = 0, maxcnt = 0;
		for (int i = 0; i < 256; i++) {
			if (MIN == 256 && count[i]) MIN = i;
			if (count[i]) MAX = i;
			total += i * count[i];
			if (count[i] > maxcnt) {
				maxcnt = count[i];
				MOD = i;
			}
			totalcnt += count[i];
		}

		AVE = total / totalcnt;
		int curcnt = 0;
		for (int i = 0; i < 256; i++) {
			curcnt += count[i];
			if (curcnt >= totalcnt / 2) {
				if (curcnt > totalcnt / 2) {
					MED = i;
					break;
				}
				if (totalcnt % 2 == 0) {
					MED = (i + i + 1) / 2.0;
					break;
				}
				else {
					MED = i + 1;
					break;
				}
			}
		}

		return { MIN, MAX, AVE, MED, MOD };
	}
};
