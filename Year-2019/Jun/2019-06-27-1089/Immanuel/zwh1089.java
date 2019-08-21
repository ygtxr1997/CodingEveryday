class Solution {
    public void duplicateZeros(int[] arr) {
        if(arr == null || arr.length < 2)
            return;

        int count = 0;
        int end = 0;
        while (count < arr.length){
            count += arr[end++] == 0? 2: 1;
        }

        if(count > arr.length){
            count--;
            arr[--count] = arr[--end];
        }
        while (end > 0){
            if(arr[end - 1] == 0){
                arr[--count] = arr[--count] = arr[--end];
            }
            else{
                arr[--count] = arr[--end];
            }
        }
        
        return;
    }
}