import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    /**
     * 采用多数投票法--两个候选人的多数投票。经典的多数投票的为该题的简单版
     * 一次循环找到票数最多的两个数，最后再一次循环统计次数是否符合规定
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0)
             return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        int ret1 = nums[0];
        int ret2 = -1;
        int count1 = 0;
        int count2 = 0;
        //根据票数，不同的都需要减1，但存在为0的时候彻底出局，最后会只剩下人数最多的两个
        for (int num : nums){
            if (ret1 == num)
                count1 ++;
            else if (ret2 == num)
                count2 ++;
            else if (count1 == 0){
                ret1 = num;
                count1 = 1;
            }
            else if (count2 == 0){
                ret2 = num;
                count2 = 1;
            }else {
                count1 -- ;
                count2 --;
            }
        }
        count1 = 0;
        count2 = 0;
        //循环统计次数
        for (int num:nums){
            if (num == ret1)
                count1 ++;
            else if (num == ret2)
                count2 ++;
        }
        if (count1 > nums.length/3)
            ret.add(ret1);
        if (count2 > nums.length/3)
            ret.add(ret2);
        return ret;
    }
}
