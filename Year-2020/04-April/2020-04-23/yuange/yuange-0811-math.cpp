// 方法二、数学方法
// 设n=25*a+10*b+5*c+d,相当于求该方程的所有非负整数解的个数
// a∈[0, n/25]
// 设rest=n-25*a
// 那么b∈[0, rest/10],
// 由于n-25*a-10*b=rest-10*b=5*c+d, 所以c∈[0, rest/5-2*b],
// 又因为a,b,c的个数一旦确定, d的个数就确定了, 所以无需再讨论d的取值范围。
// 根据上面讨论, a的个数确定以后, b、c、d的取值个数共有Σ(b=0, rest/10)(rest/5-2*b+1)种,
// 不妨设m=rest/5, n=rest/10, 则该求和公式不难求得为f(a)=(n+1)*(m+1)-n*(n+1),
// 因此, a的每个取值都使得b、c、d有f(a)种取值个数, 遍历a的所有可能值求和即可。
class Solution {
public:
    int waysToChange(int n) {
        const int mod = 1000000007;
        typedef long long ll;
        ll sum = 0;
        for (int a = 0; a <= n / 25; ++a) {
            ll rest = n - a * 25;
            ll r1 = rest / 5, r2 = rest / 10;
            sum += (r2 + 1) * (r1 + 1) % mod - r2 * (r2 + 1) % mod;
        }
        return ((sum % mod) + mod) % mod;
    }
};