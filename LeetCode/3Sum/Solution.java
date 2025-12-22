1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        Arrays.sort(nums);
5        for (int i = 0; i < nums.length - 2; i++) {
6            if (i > 0 && nums[i] == nums[i - 1]) continue;
7            int left = i + 1, right = nums.length - 1;
8            while (left < right) {
9                int sum = nums[i] + nums[left] + nums[right];
10                if (sum == 0) {
11                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
12                    while (left < right && nums[left] == nums[left + 1]) left++;
13                    while (left < right && nums[right] == nums[right - 1]) right--;
14                    left++; right--;
15                } else if (sum < 0) left++;
16                else right--;
17            }
18        }
19        return res;
20    }
21}
22