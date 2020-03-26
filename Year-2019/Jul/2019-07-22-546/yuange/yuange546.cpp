// R1 U1U2U3 R2 U4U5 [R3 V1V2V3V4 R4 V7V8 R5 ... Rm ...] ...
// R1=R2=R3=R4=R5, Ui和Vi未知，但不等于R1
// dp[i][j][k]：从Box[i]到Box[j]的盒子贡献的最大分数，且此时Box[i]左边有k个与Box[i]相同颜色的盒子
// helper(i,j,k)：辅助计算dp的函数
// 以上面的情况为例，R3的位置是i，中括号[]括起来的范围即i~j，R3左边有k=2个与之相同颜色的盒子
// 要想计算中括号[]范围内贡献的分数，只需考虑两种情况：
// 1. R3与前面的R1、R2一同消去，得3*3=9分。既然R3能和R1、R2消去，那么U1U2U3肯定在这之前消掉了，U4U5也是。
//    消去R3后，中括号内还剩[V1V2V3V4 R4 V7V8 R5 ... Rm ...]，这部分的得分通过helper(i+1, j, 0)即可计算，
//    helper的第三个参数k=0，原因是V1左边的盒子已经全部消掉，一定不存在与V1颜色相同的盒子。
// 2. R3与后面的Ri一同消去，其中i=4，5，...，m。假设R3与R4一同消去，那么消去前后的盒子情况如下，
//    R1 U1U2U3 R2 U4U5 [R3 V1V2V3V4 R4 V7V8 R5 ... Rm ...] ...
//    R1 U1U2U3 R2 U4U5 [   V1V2V3V4 R4 V7V8 R5 ... Rm ...] ...
//    既然R3能和R4一同消去，说明V1V2V3V4在这之前就已经消去，它的得分通过helper(i+1, m-1, 0)即可计算，
//    所以实际上要先消去V1V2V3V4才行，消去V1V2V3V4后盒子情况是这样的，R3总跟R4一起消去，但还不确定R4的消去方式，
//    R1 U1U2U3 R2 U4U5 [R3          R4 V7V8 R5 ... Rm ...] ...
//    R4的情况暂且未知，因为只能保证R3和R4同时消去，但并不知道R4是跟括号外的R1，R2一起消去还是和括号内的R5，R6等一起消去
//    因此除掉V1V2V3V4后，剩下中括号内的得分可以通过helper(m, j, k+1)计算，
//    helper的第三个参数k+1=2+1=3，因为此时R3也在R4右边，R4左边有k+1个与它相同颜色的盒子
// 综上，状态转移方程为：dp[i][j][k]=max((k+1)^2+helper(i+1,j,0), helper(i+1,m-1,0)+helper(m,j,k+1))，
// 其中m是遍历i~j中所有与Box[i]颜色相同的盒子。
class Solution {
private:
    int dp[101][101][101] = { 0 };
public:
    int removeBoxes(vector<int>& boxes) {
        return helper(boxes, 0, boxes.size() - 1, 0);
    }
    
    int helper(vector<int>& B, int i, int j, int k) {
        if (i > j) return 0;
        if (dp[i][j][k] != 0) return dp[i][j][k];
        while (i < j && B[i] == B[i + 1]) {
            k++;
            i++;
        }
        int res = (k + 1) * (k + 1) + helper(B, i + 1, j, 0);
        for (int m = i + 1; m <= j; ++m) {
            if (B[m] == B[i]) {
                res = max(res, helper(B, i + 1, m - 1, 0) + helper(B, m, j, k + 1));
            }
        }
        dp[i][j][k] = res;
        return res;
    }
};