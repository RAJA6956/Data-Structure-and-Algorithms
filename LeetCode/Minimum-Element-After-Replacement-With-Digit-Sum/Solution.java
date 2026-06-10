1class Solution {
2    public int minElement(int[] nums) {
3        int ans = Integer.MAX_VALUE;
4
5        for(int i = 0; i < nums.length; i++) {
6            int num = nums[i];
7            int sum = 0;
8
9            while(num > 0) {
10                sum += (num % 10);
11                num /= 10;
12            }
13
14            ans = Math.min(ans, sum);
15        }
16
17        return ans;
18    }
19}