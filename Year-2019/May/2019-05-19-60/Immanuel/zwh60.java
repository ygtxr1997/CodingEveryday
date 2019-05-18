public class Solution{
    public String getPermutation(int n, int k) {
        StringBuilder outPut = new StringBuilder();

        List<Integer> inPut = new LinkedList<>();
        int tmp = 1;
        for(int i = 1; i <= n; i++){
            inPut.add(i);
            tmp *= i;
        }
        
        k--;
        for(int i = n; i > 0; i--){
            tmp /= i;
            outPut.append(inPut.remove(k / tmp));
            k %= tmp;
        }
        
        return outPut.toString();
    }
}