public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> outPut = new ArrayList<>();
        outPut.add(1);
        for(int i = 0; i < rowIndex; i++){
            List<Integer> pre = outPut;
            outPut = new ArrayList<>();
            for(int j = 0; j <= pre.size(); j++){
                if(j - 1 < 0|| j >= pre.size())
                    outPut.add(1);
                else
                    outPut.add(pre.get(j - 1) + pre.get(j));
            }
        }

        return outPut;
    }
}