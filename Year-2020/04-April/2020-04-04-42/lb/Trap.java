package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lovely dragon
 * Date 2020/5/13 15:24
 * Description :接雨水
 */
public class Trap {
    public int trap(int[] height) {
        //寻找最高点
        //只用考虑最左边和最右边的最高点
        //边界情况
        if (height.length == 0)
            return 0;
        List<Integer> maxIndex = new LinkedList<>();
        int max = 0;
        for (int i : height)
            max = max > i?max:i ;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == max)
                maxIndex.add(i);
        }
        int area = 0;
        //方块面积
        int square=0;
        //左边分块
        int left = 0;
        int right = maxIndex.get(0);
        int high = height[left];
        int count = 0;
        for (int i = left+1; i <= right; i++) {
            if (height[i] >= high){
                area += high*count-square;
                high = height[i];
                square = 0;
                count=0;
            }else{
                square += height[i];
                count++;
            }
        }
        //中间分块
        if (maxIndex.size()>1){
            left = right;
            right = maxIndex.get(maxIndex.size()-1);
            square = 0;
            for (int i = left+1; i < right; i++) {
                square += height[i];
            }
            area += max*(right-left-1)-square;
        }
        //右边分块
        left = maxIndex.get(maxIndex.size()-1);
        right = height.length-1;
        high = height[right];
        count = 0;
        square = 0;
        for (int i = right-1; i >= left; i--) {
            if (height[i] >= high){
                area += high*count-square;
                high = height[i];
                square = 0;
                count=0;
            }else{
                square += height[i];
                count++;
            }
        }
        return area;
    }
}
