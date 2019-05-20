public class Solution{
    private boolean[] solved;
    
    private void dfs(int[][] M, int pos){
        for(int i = 0; i < M.length; i++){
            if(M[pos][i] == 1&& !solved[i]){
                solved[i] = true;
                dfs(M, i);
            }
        }
    }
    
    public int findCircleNum(int[][] M) {
        solved = new boolean[M.length];
        int outPut = 0;
        for(int i = 0; i < M.length; i++){
            if(!solved[i]){
                outPut++;
                solved[i] = true;
                dfs(M, i);
            }
        }
        
        return outPut;
    }
}