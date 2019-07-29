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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-07-03 20:29
 * @description：
 */
public class GrayCode {
    //回溯,对每一位进行修改，如果存在则进行下一个变换
    List<Integer> result;
    HashMap<String,String> link;
    public List<Integer> grayCode(int n) {
        //第一位为0
        //根据n来决定list的长度
        //寻找规律
        //00 - 01 - 11 - 10 - 00 循环
        //000  - 001  - 011  - 010  - 110  - 100  - 101  - 111
        //0000 - 0001 - 0011 - 0010 - 0110 - 0100 - 0101 - 0111 - 1111 - 1110 - 1100 - 1101 - 1001 - 1011 - 1010 - 1000
        //存储规律
        link = new HashMap<>();
        link.put("00","01");
        link.put("01","11");
        link.put("11","10");
        link.put("10","00");
        //判断循环次数
        int length = 1 << n;
        result = new ArrayList<>(length);
        if (n == 0){
            result.add(0);
            return result;
        }
        //从0开始
        int times = n/2;
        StringBuffer stringBuffer = new StringBuffer();
        if (n % 2 == 0){
            for (int i=0;i<times;i++){
                stringBuffer.append("00");
            }
            get(0,n,stringBuffer);
        }else {
            stringBuffer.append("0");
            for (int i=0;i<times;i++){
                stringBuffer.append("00");
            }
            get(1,n,stringBuffer);
            stringBuffer.replace(0,1,"1");
            get(1,n,stringBuffer);
        }
        return result;
    }

    //迭代
    public void get(int start,int n,StringBuffer stringBuffer){
        if (start >= n){
            result.add(Integer.parseInt(stringBuffer.toString(),2));
            return;
        }
        String str;
        //循环获取
        //保留之前修改
        get(start+2,n,stringBuffer);
        for (int i =0;i<3;i++){
            //取两位数
            str = stringBuffer.substring(start,start+2);
            stringBuffer.replace(start,start+2,link.get(str));
            get(start+2,n,stringBuffer);
        }
    }

}
