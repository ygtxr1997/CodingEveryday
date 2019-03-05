public class MaxArea {
    /**
     * 使用双指针从头和尾中值小的向中间靠拢，可以只计算比原来的值大的面积，再比较出最大值即可
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int start = 0;//起始点
        int end = height.length-1;//终点
        int i=0;
        int j = end;//双指针
        int ret = Math.min(height[0],height[end])*end;//输出结果
        while (i < j){
            if (height[i] < height[j]){//移动值小的指针
                if (height[start] < height[i+1]){//只计算之后的值比原来的值大的面积
                    start = i+1;//减少计算次数
                    ret = Math.max(ret,Math.min(height[start],height[end])*(end-start));
                }
                i++;
            }else {
                if (height[end] < height[j-1]){
                    end = j-1;
                    ret = Math.max(ret,Math.min(height[start],height[end])*(end-start));
                }
                j--;
            }
        }
        return ret;
    }
}
