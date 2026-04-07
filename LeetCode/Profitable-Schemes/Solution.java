#define ll long long int
const ll MOD = 1e9 + 7;
ll dp[105][105][105];
class Solution {
private:
    ll FindAns(ll index, ll n, ll men, ll minProfit, vector<int>&group, vector<int>&profit, ll curr_profit){
        if(index == n){
            if(curr_profit >= minProfit){
                return 1;
            }
            return 0;
        }
        if(dp[index][men][curr_profit] != -1){
            return dp[index][men][curr_profit];
        }
        ll ans = FindAns(index + 1, n, men, minProfit, group, profit, min(minProfit + 1, curr_profit)) % MOD; // min taken to avoid overflow
        if(men >= group[index]){
            ans += FindAns(index + 1,  n, men - group[index], minProfit, group, profit, min(minProfit + 1, curr_profit + profit[index])) % MOD; // min taken to avoid overflow
        }
        return dp[index][men][curr_profit] =  ans % MOD;
    }
public:
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        int len = group.size();
        memset(dp, -1, sizeof(dp));
        return FindAns(0, len, n, minProfit, group, profit, 0);
    }
};