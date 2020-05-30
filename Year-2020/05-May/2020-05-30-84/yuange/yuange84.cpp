class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        heights.push_back(0); //保证右边界为最后一个柱子时，方便计算
        stack<int> S; // 单调递增栈
        int maxarea(0);
        for(int i = 0; i < heights.size(); i++) {
            while(!S.empty() && heights[i] < heights[S.top()]) {
                int curheight = S.top();
                S.pop();
                //判断一下如果栈顶柱子为空，则令栈顶元素为0
                int area  = heights[curheight] * (!S.empty() ? (i - S.top() - 1) : i);
                maxarea = max(maxarea, area);
            }
            S.push(i);
        }
        return maxarea;
    }
};