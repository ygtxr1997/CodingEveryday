public class Solution {
    //从底向上递推
    //set操作太多，消耗了大量时间，可以用一个一维数组加速一下，而且用一维数组的话，可以避免对原List的修改（破坏）
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0)
            return 0;

        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }
}