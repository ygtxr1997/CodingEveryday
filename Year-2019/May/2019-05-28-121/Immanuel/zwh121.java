class Solution {
    public int maxProfit(int[] prices) {
        int outPut = 0;
        int min = Integer.MAX_VALUE;
        for(int tmp: prices){
            outPut = Math.max(outPut, tmp - min);
            min = Math.min(min, tmp);
        }
        
        return outPut;
    }
}