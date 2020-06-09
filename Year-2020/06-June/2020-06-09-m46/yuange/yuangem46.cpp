class Solution {
public:
    int translateNum(int num) {
        if (num <= 9) return 1;
        int cho = num % 100;
        if (cho <= 9 || cho >= 26) return translateNum(num / 10);
        else return translateNum(num / 10) + translateNum(num / 100); // 可拆成两种
    }
};