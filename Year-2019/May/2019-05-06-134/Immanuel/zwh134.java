class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for(int i = 0; i < len; i++){//计算从某个点到下一个点的收益
            gas[i] -= cost[i];
        }
        
        int flag = 0;
        for(int i = 0; i < len; i++){
            if(gas[i] < 0){//若收益＜0，到达不了下一个点
                flag = 0;
            }
            else if(flag == 0){//对于一连串的收益非负的点，若从第一个非负收益点出发都无法遍历全部点，那么之后的几个点也不可以，跳过他们
                flag = 1;
                int tmp = gas[i];
                int j = (i + 1) % len;
                for(; j != i; j = (j + 1) % len){
                    tmp += gas[j];
                    if(tmp < 0)
                        break;
                }
                if(j == i)
                    return i;
            }   
        }
        
        return -1;
    }
}