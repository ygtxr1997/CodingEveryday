public class MajorityElement {
    /**
     * 因为题目已经指出，众数的数量大于n/2，笑到最后的只能是众数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count=0;
        int ret = 0;
        
        for(int num:nums){
            if (count == 0)
                ret = num;
            if (ret != num)
                count --;
            else
                count ++;
        }
        return ret;
    }
}
