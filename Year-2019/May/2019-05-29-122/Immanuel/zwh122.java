public class Solution {
    //底谷买入，顶峰卖出，写得有些啰嗦了
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        
        int outPut = 0;
        int pos = 1;
        while (pos < prices.length){
            if(prices[pos] > prices[pos - 1]){
                //到达底谷
                int tmp = 0;
                while (pos < prices.length&& prices[pos] >= prices[pos - 1]){
                    //顶峰时卖出
                    tmp += prices[pos] - prices[pos++ - 1];
                }
                outPut += Math.max(0, tmp);
            }
            else pos++;
        }

        return outPut;
    }
}