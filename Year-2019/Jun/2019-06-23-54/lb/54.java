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
    //嵌套，每完成一次循环就是一个新循环
    public List<Integer> spiralOrder(int[][] matrix) {
        int loop = 0;
        List<Integer> result = new LinkedList<>();
        //同时考虑行与列的长度来判断是否完成循环
        while (matrix.length - loop*2 > 0 && matrix[0].length - loop*2 > 0){
            for (int i = loop; i < matrix[0].length-loop; i++) {
                result.add(matrix[loop][i]);
            }
            //只剩最后一行时直接跳出循环
            if(loop == matrix.length/2){
                break;
            }
            for (int i = loop+1; i< matrix.length - loop; i++) {
                result.add(matrix[i][matrix[0].length - loop-1]);
            }
            //只剩最后一列时直接跳出循环
            if (loop == matrix[0].length/2){
                break;
            }
            for (int i = matrix[0].length - loop-2; i >= loop ; i--) {
                result.add(matrix[matrix.length - loop-1][i]);
            }
            for (int i = matrix.length - loop - 2; i > loop ; i--) {
                result.add(matrix[i][loop]);
            }
            loop ++;
        }
        return result;
    }

}
