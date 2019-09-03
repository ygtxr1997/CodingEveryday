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

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-09-01 19:14
 * @description：
 */
public class CompareVersion {
    //版本号比较
    //对于0和空需要特别注意，比如0和0.0的比较
    //长度不同时--补零
    //字符串补零
    public int compareVersion(String version1, String version2) {
        //根据点分割版本号
        //其中因为.为转义字符，所以直接使用"."不能得到正确的结果
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        //比较相同大小版本的大小
        int loop = Math.min(v1.length,v2.length);
        int m,n;
        for (int i = 0; i < loop; i++) {
            m = Integer.valueOf(v1[i]);
            n = Integer.valueOf(v2[i]);

            if (m > n){
                return 1;
            }
            if (m < n)
                return -1;
        }

        //判断之后是否为0的情况
        if (v1.length > v2.length){
            for (int i = loop; i < v1.length; i++) {
                if (Integer.valueOf(v1[i]) > 0)
                    return 1;
            }
        }else {
            for (int i = loop; i < v2.length; i++) {
                if (Integer.valueOf(v2[i]) > 0)
                    return -1;
            }
        }
        return 0;
    }
}
