class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> nums   = new Stack<>();
        HashMap<Integer,Integer> ret = new HashMap<>();
        int[] result = new int[nums1.length];
        int temp;
        for (int i : nums2){
            if (nums.size()==0 || nums.peek()>=i){
                nums.push(i);
            }else {
                while(nums.size()>0 && nums.peek()<i){
                    ret.put(nums.pop(),i);
                }
                nums.push(i);
            }
        }
        while (nums.size()>0){
            ret.put(nums.pop(),-1);
        }
        for (int i=0;i<nums1.length;i++){
            result[i] = ret.get(nums1[i]);
        }
        return result;
    }
}
