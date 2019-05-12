public class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> outPut = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for(int[] tmp: buildings){
            height.add(new int[] {tmp[0], -tmp[2]});
            height.add(new int[] {tmp[1], tmp[2]});
        }

        Collections.sort(height, (x1, x2) ->{
            if(x1[0] != x2[0])
                return x1[0] - x2[0];
            else
                return x1[1] - x2[1];
        });

        PriorityQueue<Integer> heap = new PriorityQueue<>((x1, x2) ->{
            return x2 - x1;
        });

        heap.offer(0);
        int pre = 0;
        for(int[] tmp: height){
            if(tmp[1] < 0){
                heap.offer(-tmp[1]);
            }
            else {
                heap.remove(tmp[1]);
            }
            int cur = heap.peek();
            if(cur != pre){
                outPut.add(Arrays.asList(new Integer[]{tmp[0], cur}));
                pre = cur;
            }
        }

        return outPut;
    }
    
}