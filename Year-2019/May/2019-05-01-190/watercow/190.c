// unsigned int
// 学了一个新库 <bitset>
class Solution {
public:
	uint32_t reverseBits(uint32_t n) {
		bitset<32> bit = n;

		for (int i = 0; i < 16; i++) {
			if (bit[i] != bit[31 - i]) {
				bit[i] = !bit[i];
				bit[31 - i] = !bit[31 - i];
			}
		}
		return bit.to_ulong();
	}
};
