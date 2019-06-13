public class Solution {
    public int kthGrammar(int N, int K) {
        if(N == 1)
            return 0;
        
        int pre = (int)Math.pow(2, N - 2);
        if(K > pre){
            return 1 - kthGrammar(N - 1, K - pre);
        }
        else 
            return kthGrammar(N - 1, K);
    }
}