class Solution {
//使用set判断数量是否一致
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num:nums)
            set.add(num);
        if (set.size()!=nums.length)
            return true;
        return false;
    }
}
