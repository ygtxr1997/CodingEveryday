// 官方第四种方法 双指针
int trap(vector<int>& height) {
    int left = 0, right = height.size() - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;

    while(left < right) {
        if (height[left] < height[right]) {
            height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
            left++;
        }
        else {
            height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
            right--;
        }
    }

    return ans;
}
