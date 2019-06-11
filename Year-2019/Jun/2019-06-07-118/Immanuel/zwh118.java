public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outPut = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> cur = new ArrayList<>();
            for(int j = 0; j <= pre.size(); j++){
                if(j - 1 < 0|| j >= pre.size()){
                    cur.add(1);
                }
                else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            outPut.add(cur);
            pre = cur;
        }

        return outPut;
    }
}