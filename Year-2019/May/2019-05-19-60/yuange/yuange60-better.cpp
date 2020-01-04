// 0ms, 100%
// 思路是dfs树的第i层有n-i个叶子节点
class Solution {
private:
    list<char> ls; // 辅助链表
    int m_k; // 保存输入的k
    // 返回元素位置, n为链表长度
    int get_k (int n) {
        int f = fact(n - 1);
        int res = 0;
        while (m_k > f) {
            res++;
            m_k -= f;
        }
        return (res + 1);
    }
    // 获取链表第k个元素, 然后删除该元素
    char get_list_k (int k) {
        auto it = ls.begin();
        for (int i = 0; i < k - 1; ++i) it++;
        char res = *it;
        ls.erase(it);
        return res;
    }
public:
    string getPermutation(int n, int k) {
        m_k = k;
        string res = "";
        for (int i = 1; i <= n; ++i) ls.push_back('0' + i);
        for (int i = n; i >= 1; --i) res += get_list_k(get_k(i));
        return res;
    }
    
    int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; ++i) res *= i;
        return res;
    }
};