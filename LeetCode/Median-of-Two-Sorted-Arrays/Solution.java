1public class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        // Ensure nums1 is the smaller array for optimized binary search
4        if (nums1.length > nums2.length) {
5            return findMedianSortedArrays(nums2, nums1);
6        }
7        
8        int m = nums1.length;
9        int n = nums2.length;
10        int low = 0, high = m;
11        
12        while (low <= high) {
13            int partition1 = (low + high) / 2;
14            int partition2 = (m + n + 1) / 2 - partition1;
15            
16            // If partition1 is 0, it means nothing is left on the left side of nums1
17            // If partition1 is m, it means all elements are on the left side
18            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
19            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
20            
21            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
22            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
23            
24            // Check if the partition is correct
25            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
26                // If the total number of elements is odd
27                if ((m + n) % 2 == 1) {
28                    return Math.max(maxLeft1, maxLeft2);
29                } else {
30                    // If the total number of elements is even
31                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
32                }
33            } else if (maxLeft1 > minRight2) {
34                // Move partition1 to the left
35                high = partition1 - 1;
36            } else {
37                // Move partition1 to the right
38                low = partition1 + 1;
39            }
40        }
41        
42        throw new IllegalArgumentException("Input arrays are not sorted");
43    }
44
45    public static void main(String[] args) {
46        Solution solution = new Solution();
47        
48        int[] nums1 = {1, 3};
49        int[] nums2 = {2};
50        System.out.println("Median: " + solution.findMedianSortedArrays(nums1, nums2)); // Output: 2.0
51        
52        int[] nums3 = {1, 2};
53        int[] nums4 = {3, 4};
54        System.out.println("Median: " + solution.findMedianSortedArrays(nums3, nums4)); // Output: 2.5
55    }
56}
57