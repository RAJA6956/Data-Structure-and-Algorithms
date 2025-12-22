1class Solution {
2    public int missingNumber(int[] nums) {
3        ArrayList<Integer> temp =new ArrayList<>();
4        for(int i=0;i<=nums.length;i++){
5            temp.add(i);
6        }
7        for(int i=0;i<nums.length;i++){
8            temp.remove(Integer.valueOf(nums[i]));
9        }
10        return temp.get(0);
11        
12    }
13}