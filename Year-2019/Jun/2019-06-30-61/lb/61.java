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
 * @date ：Created in 2019-07-30 21:42
 * @description：
 */
public class RotateRight {
    //首尾相连，再从第n-k个位置断开
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode last = head;
        int length = 1;
        while (last.next != null){
            last = last.next;
            length ++;
        }
        //存在k>length的情况
        if (k > length){
            k = k%length;
        }
        //确定新新链表的链头
        //1 -> 2 -> 3 -> 4
        //0    3    2    1   +length -->排除0
        last.next = head;
        //head为链尾
        for (int i = 0; i < 2*length-k-1; i++) {
            head = head.next;
        }
        last = head;
        head = head.next;
        last.next = null;
        return head;
    }
}
