public class Solution{
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2)
            return intervals;
        
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        intervals[0][0] = starts[0];
        intervals[0][1] = ends[0];
        int count = 0;
        for(int i = 1; i < intervals.length; i++){
            if(starts[i] <= intervals[count][1]){
                intervals[count][1] = ends[i];
            }
            else {
                intervals[++count][0] = starts[i];
                intervals[count][1] = ends[i];
            }
        }
        
        return Arrays.copyOf(intervals, count + 1);
    }
    
    
//     public int[][] merge(int[][] intervals) {
//         if(intervals.length < 2)
//             return intervals;
        
//         Arrays.sort(intervals, (x1, x2) -> {
//             if(x1[0] < x2[0]) return -1;
//             else if(x1[0] > x2[0]) return 1;
//             else {
//                 if(x1[1] < x2[1]) return -1;
//                 else if(x1[1] > x2[1]) return 1;
//                 else return 0;
//             }
//         });

//         int[][] outPut = new int[intervals.length][2];
//         int count = -1;
//         outPut[++count][0] = intervals[0][0];
//         outPut[count][1] = intervals[0][1];

//         for(int i = 1; i < intervals.length; i++){
//             if(intervals[i][0] <= outPut[count][1]){
//                 outPut[count][1] = Math.max(outPut[count][1], intervals[i][1]);
//             }
//             else{
//                 outPut[++count][0] = intervals[i][0];
//                 outPut[count][1] = intervals[i][1];
//             }
//         }

//         return Arrays.copyOf(outPut, count + 1);
//     }
}