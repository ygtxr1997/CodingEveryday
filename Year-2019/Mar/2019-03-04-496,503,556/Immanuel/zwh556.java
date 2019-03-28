class Solution {
    public int nextGreaterElement(int n) {
        int outPut = n;
        int[] tmp = new int[10];
        int count = 0;
        while(outPut != 0){
            tmp[count++] = outPut % 10;
            outPut /= 10; 
        }
        int end = 1;
        while(end < count&& tmp[end] >= tmp[end - 1]){
            end++;
        }
        if(end == count) 
            return -1;
        int i = 0;
        while(tmp[i] <= tmp[end]){
            i++;
        }
        outPut = tmp[i];
        tmp[i] = tmp[end];
        tmp[end] = outPut;
        i = 0;
        end--;
        while(i < end){
            outPut = tmp[i];
            tmp[i++] = tmp[end];
            tmp[end--] = outPut;
        }
        outPut = 0;
        for(i = count - 1; i >= 0; i--){
            outPut *= 10;
            outPut += tmp[i];
        }
        if(outPut > n)
            return outPut;
        else
            return -1;
    }
}