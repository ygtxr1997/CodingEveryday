class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int outPut = Integer.MIN_VALUE;
        while(left < right){
            int shortPlate = Math.min(height[left], height[right]);
            outPut = Math.max(outPut, (right - left) * shortPlate);
            while(left < right&& height[left] <= shortPlate) left++;
            while(left < right&& height[right] <= shortPlate) right--;
        }
        return outPut;
    }
}