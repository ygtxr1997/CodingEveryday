/***
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * 单身狗就这样默默地看着你，一句话也不说。
 */

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-07-30 13:07
 * @description：
 */
public class SpiralOrder {
    //在获取每位数的位置替换成插入每位数
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int loop = 0;
        int num = 1;
        //同时考虑行与列的长度来判断是否完成循环
        while (matrix.length - loop*2 > 0 && matrix[0].length - loop*2 > 0){
            for (int i = loop; i < matrix[0].length-loop; i++) {
                matrix[loop][i] = num;
                num++;
            }
            //只剩最后一行时直接跳出循环
            if(loop == matrix.length/2){
                break;
            }
            for (int i = loop+1; i< matrix.length - loop; i++) {
                matrix[i][matrix[0].length - loop-1] = num;
                num++;
            }
            //只剩最后一列时直接跳出循环
            if (loop == matrix[0].length/2){
                break;
            }
            for (int i = matrix[0].length - loop-2; i >= loop ; i--) {
                matrix[matrix.length - loop-1][i] = num;
                num++;
            }
            for (int i = matrix.length - loop - 2; i > loop ; i--) {
                matrix[i][loop] = num;
                num++;
            }
            loop ++;
        }
        return matrix;
    }
}
