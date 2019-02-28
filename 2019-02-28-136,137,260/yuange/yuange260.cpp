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
// 还是用异或，设单独出现的数字为a和b，与a异或某位为1但与b该位异或为0的数分成两组
class Solution {
public:
	vector<int> singleNumber(vector<int>& nums) {
		int x = 0, a = 0, b = 0;
		for (auto item : nums)
			x ^= item;
		x &= -x; // 使用这种方式可以更快地找到异或bit位为1的位置
		for (auto item : nums)
		{
			if (item & x)
				a ^= item;
			else
				b ^= item;
		}
		return vector<int>{a, b};
	}
};