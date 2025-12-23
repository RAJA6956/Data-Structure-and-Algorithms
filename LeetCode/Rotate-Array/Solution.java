1class Solution {
2    public void rotate(int[] nums, int k) {
3        int n = nums.length;
4        k = k % n; 
5        reverse(nums, 0, n - 1);      
6        reverse(nums, 0, k - 1);      
7        reverse(nums, k, n - 1);      
8    }
9    private void reverse(int[] nums, int start, int end) {
10        while (start < end) {
11            int temp = nums[start];
12            nums[start] = nums[end];
13            nums[end] = temp;
14            start++;
15            end--;
16        }
17    }
18}
19