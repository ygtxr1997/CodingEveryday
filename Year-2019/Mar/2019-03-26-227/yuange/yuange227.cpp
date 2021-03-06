/***
 *_______________#########_______________________
 *______________############_____________________
 *______________#############____________________
 *_____________##_############___________________
 *____________###__######_#####__________________
 *____________###_########__####_________________
 *___________###__##########_####________________
 *__________####__###########_####_______________
 *________#####___###########__#####_____________
 *_______######___###_########___#####___________
 *_______#####___###___########___######_________
 *______######___###__###########___######_______
 *_____######___####_##############__######______
 *____#######__#####################_#######_____
 *____#######__##############################____
 *___#######__######_#################_#######___
 *___#######__######_######_#########___######___
 *___#######____##__######___######_____######___
 *___#######________######____#####_____#####____
 *____######________#####_____#####_____####_____
 *_____#####________####______#####_____###______
 *______#####______;###________###______#________
 *________##_______####________####______________
 */
/*
 * @Author: yuange
 * @LastEditors: yuange
 * @Description: Coding everyday!
 * @Date: 2019-03-27 12:00:09
 * @LastEditTime: 2019-03-27 12:00:24
 */
// 用栈辅助，16ms,79%
class Solution {
public:
    int calculate(string s) {
        int ret = 0, d = 0;
        char sign = '+';
        stack<int> st;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] >= '0') d = d * 10 - '0' + s[i];
            if ((s[i] < '0' && s[i] != ' ') || i == s.size() - 1) {
                if (sign == '+') st.push(d);
                else if (sign == '-') st.push(-d);
                else if (sign == '*' || sign == '/') {
                    int tmp = sign == '*' ? st.top() * d : st.top() / d;
                    st.pop();
                    st.push(tmp);
                }
                sign = s[i]; //保存当前符号
                d = 0;
            }
        }
        while(!st.empty()) {
            ret += st.top();
            st.pop();
        }
        return ret;
    }
};