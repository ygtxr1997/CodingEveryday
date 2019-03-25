import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private void getCopy(Point[] outPut, Point[] inPut, int begin){
        for(int i = 0; i < outPut.length; i++){
            outPut[i] = new Point(inPut[begin + i].x, inPut[begin + i].y);
        }
    }

    private int getNum(List<Point[]> byX, int pos, int pi, int x1, int y1){
        int tx = byX.get(pos)[pi].x;
        int ty = byX.get(pos)[pi].y;
        int num = 0;
        for(int i = 0; i < byX.get(pos).length; i++){
            if(byX.get(pos)[i].y == ty)
                num++;
            else if(byX.get(pos)[i].y > ty)
                break;
        }
        for(int i = pos + 1; i < byX.size(); i++){
            for(int j = 0; j < byX.get(i).length; j++){
                if((long)(byX.get(i)[j].y - ty) * x1 == (long)(byX.get(i)[j].x - tx) * y1)
                    num++;
            }
        }
        for(int i = pos - 1; i > -1; i--){
            for(int j = 0; j < byX.get(i).length; j++){
                if((long)(byX.get(i)[j].y - ty) * x1 == (long)(byX.get(i)[j].x - tx) * y1)
                    num++;
            }
        }

        return num;
    }

    public int maxPoints(Point[] points) {
        if(points.length < 3)
            return points.length;
        int outPut = 0;

        Arrays.sort(points, (Point first, Point second) -> {
            if(first.x == second.x){
                return first.y - second.y;
            }
            else{
                return first.x - second.x;
            }
        });

        List<Point[]> byX = new ArrayList<>();
        int tmpx = points[0].x;
        int tmpp = 0;
        for(int i = 0; i < points.length; i++){
            if(points[i].x != tmpx){
                Point[] tmp = new Point[i - tmpp];
                getCopy(tmp, points, tmpp);
                byX.add(tmp);
                tmpx = points[i].x;
                tmpp = i;
            }
        }
        Point[] tmp = new Point[points.length - tmpp];
        getCopy(tmp, points, tmpp);
        byX.add(tmp);

        for(int i = 0; i < byX.size(); i++){
            outPut = Math.max(outPut, byX.get(i).length);
        }

        for(int begin = 0; begin < byX.size() - 1; begin++){
            for (int end = begin + 1; end < byX.size(); end++){
                for(int bi = 0; bi < byX.get(begin).length; bi++){
                    for(int ei = 0; ei < byX.get(end).length; ei++){
                        outPut = Math.max(outPut, getNum(byX, begin, bi, byX.get(end)[ei].x - byX.get(begin)[bi].x, byX.get(end)[ei].y - byX.get(begin)[bi].y));
                    }
                }
            }
        }

        return outPut;
    }
}