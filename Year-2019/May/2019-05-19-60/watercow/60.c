// 回溯效率过分感人
// 推荐用户SEU.FidGet的解法
/**
直接用回溯法做的话需要在回溯到第k个排列时终止就不会超时了, 但是效率依旧感人
可以用数学的方法来解, 因为数字都是从1开始的连续自然数, 排列出现的次序可以推
算出来, 对于n=4, k=15 找到k=15排列的过程:

1 + 对2,3,4的全排列 (3!个)
2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)

确定第一位:
k = 14(从0开始计数)
index = k / (n-1)! = 2, 说明第15个数的第一位是3
更新k
k = k - index*(n-1)! = 2
确定第二位:
k = 2
index = k / (n-2)! = 1, 说明第15个数的第二位是2
更新k
k = k - index*(n-2)! = 0
确定第三位:
k = 0
index = k / (n-3)! = 0, 说明第15个数的第三位是1
更新k
k = k - index*(n-3)! = 0
确定第四位:
k = 0
index = k / (n-4)! = 0, 说明第15个数的第四位是4
最终确定n=4时第15个数为3214
**/

class Solution {
public:
	string getPermutation(int n, int k) {
		vector<int> factorial(n + 1, 1); //记录阶乘结果
		vector<int> res(n + 1, 0); // 记录每一位应该的结果
		vector<int> candidate(n + 1, 1); // 记录每次index只能选择的候选数字

		// 计算阶乘结果
		for (int i = 1; i < n + 1; i++) {
			candidate[i] = i;
			factorial[i] = factorial[i - 1] * i;
		}


		// 依次遍历每一位，从高到低
		for (int j = n; j > 0; j--) {

			int index = ceil(double(k) / double(factorial[j - 1]));

			res[j] = candidate[index];
			candidate.erase(candidate.begin() + index);

			k = k - (index - 1) * factorial[j - 1]; // 这一步一定要注意 是(index - 1)而不是index，自己想why
		}
        
		// 生成最终返回结果
		string ret = "";
		for (int i = n; i > 0; i--) {
			ret += res[i] + '0';
		}

		return ret;
	}
};
