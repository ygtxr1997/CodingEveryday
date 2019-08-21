class Solution {
    public int climbStairs(int n) {
        if(n < 2)
            return n;
        
        int pre = 0, post = 1;
        while(--n > 0){
            int tmp = pre + post;
            pre = post;
            post = tmp;
        }
        
        return pre + post;
    }
}