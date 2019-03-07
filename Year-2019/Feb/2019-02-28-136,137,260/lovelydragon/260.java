import java.util.ArrayList;
import java.util.List;

public class SingleNumber {

    /**
     * 异或数组中的所有值，得出的结果即为那两个数相异或的结果。然后根据结果中1的位数来分割成两个数组，这样就可以把这两个数分割开来了
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int ret = 0;//异或结果
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();//分割的两个数组
        int[] retsult = new int[2];
        for (int num:nums)//数组所有值的异或结果
            ret ^= num;
        int i =0;
        for (;i<32;i++){//寻找1位数的位置
            if ((ret & (1<<i)) == 1<<i)
                break;;
        }
        for (int num:nums){//分割数组
            if ((num & (1<< i)) == 1<<i)
                a.add(num);
            else
                b.add(num);
        }
        ret = 0;//找出结果
        for (int num:a)
            ret ^= num;
        retsult[0] = ret;
        ret =0;
        for (int num:b)
            ret ^= num;
        retsult[1] = ret;
        return retsult;
    }
}
