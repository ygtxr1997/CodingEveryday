public class Solution {
    //O(n^2)

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (x1, x2) -> {
            return x1[0] != x2[0]? x1[0] - x2[0]: x1[1] - x2[1];
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        int outPut = 0;
        for(int i = 0; i < envelopes.length; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0]&& envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            outPut = Math.max(outPut, dp[i]);
        }

        return outPut;
    }

    
//想法：按width分组，每个套娃可以只计算与自己同width且height刚好小于自己的套娃，以及width小于自己的每组套娃中height恰好小于自己的套娃中的最大值，然后加一即可
//然而事与愿违，效果反不如初
//     private class Envelop{
//         int width;
//         int height;
//         int num;
//         public Envelop(int x1, int x2, int x3){
//             width = x1;
//             height = x2;
//             num = x3;
//         }
//     }

//     public int maxEnvelopes(int[][] envelopes) {
//         Arrays.sort(envelopes, (x1, x2) -> {
//             return x1[0] != x2[0]? x1[0] - x2[0]: x1[1] - x2[1];
//         });

//         List<List<Envelop>> inPut = new ArrayList<>();
//         List<Envelop> tmpList = new ArrayList<>();
//         int pre = 0;
//         for(int[] tmp: envelopes){
//             if(tmp[0] > pre){
//                 inPut.add(tmpList);
//                 tmpList = new ArrayList<>();
//                 pre = tmp[0];
//             }
//             tmpList.add(new Envelop(tmp[0], tmp[1], 1));
//         }
//         inPut.add(tmpList);
//         inPut.remove(0);


//         int outPut = 0;
//         for(int i = 0; i < inPut.size(); i++){
//             List<Envelop> tmpList1 = inPut.get(i);
//             for(int j = 0; j < tmpList1.size(); j++){
//                 Envelop tmp = tmpList1.get(j);
//                 if(j > 0){
//                     tmp.num = inPut.get(i).get(j - 1).num;
//                 }
//                 for(int k = 0; k < i; k++){
//                     List<Envelop> tmpList2 = inPut.get(k);
//                     for(int l = tmpList2.size() - 1; l >= 0; l--){
//                         if(tmp.height > tmpList2.get(l).height){
//                             tmp.num = Math.max(tmp.num, 1 + tmpList2.get(l).num);
//                             break;
//                         }
//                     }
//                 }
//                 outPut = Math.max(outPut, tmp.num);
//             }
//         }

//         return outPut;
//     }
}