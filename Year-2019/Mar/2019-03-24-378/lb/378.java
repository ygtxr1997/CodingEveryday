import java.util.Stack;

public class KthSmallest {
    /**
     * 保存每行的指针进行比较，循环找出第k小的数
     * 时间复杂度为nk
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int ret = 0;
        int[] point = new int[length];
        for (int i = 0;i<length;i++){
            point[i] = 0;
        }
        for (int i = 0;i< k ;i++)
            ret = compare(point,matrix);
        return ret;
    }
    public int compare(int[] p,int[][] matrix){
        int index = 0;
        int min = Integer.MAX_VALUE;
        int length  = p.length;
        for (int i=0;i<length;i++){
            if (matrix[i][p[i]]<min){
                min = matrix[i][p[i]];
                index = i;
            }
        }
        if (p[index] == length-1)
            matrix[index][p[index]] = Integer.MAX_VALUE;
        else
            p[index]++;
        return min;
    }
}
