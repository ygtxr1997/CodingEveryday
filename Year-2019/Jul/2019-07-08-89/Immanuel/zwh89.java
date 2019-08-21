class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> outPut = new ArrayList();
        outPut.add(0);
        int tmp = 1;
        for(int i = 0; i < n; i++){
            int size = outPut.size();
            for(int j = size - 1; j > -1; j--){
                outPut.add(outPut.get(j) + tmp);
            }
            tmp *= 2; 
        }
        return outPut;
    }
}