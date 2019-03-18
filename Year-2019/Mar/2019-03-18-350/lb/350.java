class Solution {
//使用排序进行查找
//如果某一数组的数量要少，可以使用map进行查找
    public int[] intersect(int[] nums1, int[] nums2) {
         Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> add = new ArrayList<>();
        for (int i=0,j=0;i<nums1.length && j<nums2.length;){
            if (nums1[i] > nums2[j]){
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]){
                i++;
                continue;
            }
            add.add(nums1[i]);
            i++;
            j++;
            
        }
        int[] ret = new int[add.size()];
        for (int i =0;i<add.size();i++){
            ret[i] = add.get(i);
        }
        return ret;
    }
}
