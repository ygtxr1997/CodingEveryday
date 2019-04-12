class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int tmp: nums){
            if(set.contains(tmp))
                return true;
            else{
                set.add(tmp);
            }
        }
        return false;
    }
}