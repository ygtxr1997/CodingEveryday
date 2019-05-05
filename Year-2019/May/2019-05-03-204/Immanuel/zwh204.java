class Solution {
    
    public int countPrimes(int n) {
        if(n < 3)
            return 0;
        boolean[] notPrime = new boolean[n];
        
        int count = 0;
        for(int i = 2; i < n; i++){
            if(!notPrime[i]){
                count++;
                for (int j = 2 * i; j < n; j += i){
                    notPrime[j] = true;
                }
            }
        }
        
        return count;
    }
    
    // private boolean isPrimeNum(int n){
    //     int tmp = (int)Math.sqrt(n);
    //     tmp++;
    //     for(int i = 2; i < tmp; i++){
    //         if(i * (n / i) == n)
    //             return false;
    //     }   
    //     return true;
    // }  
    // public int countPrimes(int n) {
    //     int count = 0;
    //     if(2 < n)
    //         count++;
    //     for(int i = 3; i < n; i += 2){
    //         if(isPrimeNum(i))
    //             count++;
    //     }      
    //     return count;
    // }
}