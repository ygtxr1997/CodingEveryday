public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: A){
            for(int j: B){
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }

        int outPut = 0;
        for(int i: C){
            for(int j: D){
                outPut += map.getOrDefault(-i - j, 0);
            }
        }

        return outPut;
    }
}