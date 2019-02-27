/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */
#define INF 0x3f3f3f3f
#include <unordered_map>
#include <osstream>
class Solution {
public:
    int maxPoints(vector<Point> &points) {
        int n = points.size();
        if (n == 0) return 0;
        int maxNum=0;
        int same=0;
        for (int i = 0; i < n; i++) {
            unordered_map<string,int> pointLine;
            same=0;
            for (int j = 0; j < i; j++) {
                if(j == i) continue;
                int x1 = points[i].x, y1 = points[i].y, x2 = points[j].x, y2 = points[j].y;
                int dx = x1 - x2, dy = y1 - y2;
                if(dx == 0 && dy == 0) same++; // 重复点
                else if(dx == 0) pointLine[i2str(INF, 0)]++; // 平行于y轴
                else { // 常规点
                    int g = gcd(dx, dy);
                    pointLine[i2str(dy/g, dx/g)]++;
                }
            }
            int lineMax=0;
            for(auto it = pointLine.begin(); it != pointLine.end(); it++) { // 找点最多的直线斜率
                if(it->second > lineMax) lineMax=it->second;
            }
            maxNum = max(lineMax + same, maxNum); // lineMax + same即过该点的直线经过点的最大值
        }
        return maxNum + 1; // 记住+1
    }
    
    int gcd(int a, int b)
    {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
    
    // 斜率k=k1/k2
    inline string i2str(int k1, int k2)
    {
        ostringstream oss;
        oss << k1 << '-' << k2;
        return oss.str();
    }
};
