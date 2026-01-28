1import java.util.*;
2
3public class Solution {
4    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
5        if (k <= 0 || t < 0) return false;
6        
7        TreeSet<Long> set = new TreeSet<>();
8        
9        for (int i = 0; i < nums.length; i++) {
10            long num = nums[i];
11            
12            // Find smallest number >= num - t
13            Long floor = set.ceiling(num - (long)t);
14            if (floor != null && floor <= num + (long)t) {
15                return true;
16            }
17            
18            set.add(num);
19            
20            // Maintain window size of k
21            if (i >= k) {
22                set.remove((long)nums[i - k]);
23            }
24        }
25        
26        return false;
27    }
28}
29