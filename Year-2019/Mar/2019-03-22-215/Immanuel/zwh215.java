class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length, ( x1, x2) -> {
//             return x2 - x1;
//         });
//         for(int i = 0; i < nums.length; i++){
//             heap.add(nums[i]);
//         }
//         int outPut = 0;
//         while(k > 0){
//             outPut = heap.poll();
//             k--;
//         }
//         return outPut;
//     }
    
    private void adjustT2B(int[] nums, int pos, int size){
        int next = pos;
        int tmp = 2 * pos + 1;
        while(tmp < size){
            next = nums[next] >= nums[tmp]? next: tmp;
            if(++tmp < size){
                next = nums[next] >= nums[tmp]? next: tmp;
            }
            if(next == pos){
                break;
            }
            else{
                tmp = nums[pos];
                nums[pos] = nums[next];
                nums[next] = tmp;
                pos = next;
                tmp = 2 * pos + 1;
            }
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        for(int i = (nums.length - 1) / 2; i >= 0; i--){
            adjustT2B(nums, i, nums.length);
        }
        
        for(int i = 1; i < k; i++){
            nums[0] = nums[nums.length - i];
            adjustT2B(nums, 0, nums.length - i);
        }
        return nums[0];
    }
    
    
//     private int partition(int[] nums, int left, int right){
//         int pivot = nums[left];
//         while (left < right){
//             while (left < right&& nums[right] < pivot) right--;
//             if(left < right)
//                 nums[left++] = nums[right];
//             while (left < right&& nums[left] >= pivot) left++;
//             if(left < right)
//                 nums[right--] = nums[left];
//         }
//         nums[left] = pivot;
//         return left;
//     }
//     public int findKthLargest(int[] nums, int k) {
//         k--;
//         int left = 0;
//         int right = nums.length - 1;
//         int tmp = partition(nums, left, right);
//         while (tmp != k){
//             if(tmp < k){
//                 left = tmp + 1;
//                 tmp = partition(nums, left, right);
//             }
//             else{
//                 right = tmp - 1;
//                 tmp = partition(nums, left, right);
//             }
//         }

//         return nums[k];
//     }
}