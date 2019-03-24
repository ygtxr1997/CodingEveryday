class Solution {
//二维数组的二分查找法
    public int kthSmallest(int[][] matrix, int k) {
     int n=matrix.length;
        int lo=matrix[0][0];
        int hig=matrix[n-1][n-1];
        while(lo<=hig){
          //mid 为最小值和最大值的中间值
            int mid=lo+(hig-lo)/2;
            int count=getmid(matrix,mid);
            if(count<k)
                lo=mid+1;
            else
                hig=mid-1;
        }
        return lo;
    }
    //
 public int getmid(int[][] matrix,int mid){
     int n=matrix.length;
     int res=0;
     for(int i=n-1,j=0;i>=0&&j<n;){
         if(matrix[i][j]>mid)
             i--;
         else{
             res+=i+1;
             j++;
         }       
     }
     return res;
 }   
}
