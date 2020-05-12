package com.company;

public class Jump {
    //跳跃游戏Ⅱ
    //贪心算法，取第二跳最远的点--因为这个点可以达到所有第一跳的点再跳一次的位置
    public int jump(int[] nums) {
        int steps = 0;
        //达到最后一个位置时不需要再跳了
        for (int i = 0; i < nums.length-1;) {
            if (i + nums[i] >= nums.length - 1){
                steps++;
                break;
            }
            //第二跳的位置
            int max = i;
            //第二条最远第一跳的位置
            int maxi = i+1;
            //j表示第一跳的位置，可以为最后一个位置
            for (int j = i+1; j < nums.length && j <= i+nums[i] ; j++) {
                //第二跳
                if (j + nums[j] >= max){
                    maxi = j;
                    max = j + nums[j];
                }
            }
            i = maxi;
            steps++;
        }
        return steps;
    }
}
