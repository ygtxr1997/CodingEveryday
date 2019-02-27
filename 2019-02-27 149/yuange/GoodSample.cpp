//104ms过大集合
//https://blog.csdn.net/feliciafay/article/details/20704629
/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */
class Solution {
public:
    int maxPoints(vector<Point> &points) {
        if(points.size()==0)
            return 0;
        int max_num=0;
        int same_point_num=0;
        for(int i=0;i<(int)points.size();i++){
            map<double,int> slope_map;
            same_point_num=0;
            for(int j=0;j<(int)points.size();j++){
                if(j==i) // i和i自己不需要计算
                    continue;
                if(points[i].x-points[j].x==0&&points[i].y-points[j].y==0) //相同点
                    same_point_num++;
                else if(points[i].x-points[j].x==0&&points[i].y-points[j].y!=0) //斜率为tan90°的点
                    slope_map[INT_MAX]++;
                else
                    slope_map[double(points[j].y-points[i].y)/(points[j].x-points[i].x)]++; //正常点，注意double写的位置
            }
            int tmp_max=0;
            for(map<double,int>::iterator it=slope_map.begin();it!=slope_map.end();it++){ //找到map中含有最多的点的斜率
                if(it->second>tmp_max)
                    tmp_max=it->second;
            }
            if(tmp_max+same_point_num>max_num) //用map中的最多点再加上same_point_num得到的数和历史的最大值做比较跟新历史最大值
                max_num=tmp_max+same_point_num;
        }
        return max_num+1;//当max_num为1时，确定了1条直线，2个点；当max_num为2时，确定了3个点;当max_num为i时，确定了i+1个点。
    }
};
