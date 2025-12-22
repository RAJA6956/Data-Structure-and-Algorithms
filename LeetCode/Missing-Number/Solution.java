1class Solution {
2    public int missingNumber(int[] nums) {
3        int missing = nums.length; // start with n
4        for (int i = 0; i < nums.length; i++) {
5            missing ^= i ^ nums[i]; // XOR index and value
6        }
7        return missing;
8    }
9}
10