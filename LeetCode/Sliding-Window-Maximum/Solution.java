1import java.util.*;
2
3public class Solution {
4    public int[] maxSlidingWindow(int[] nums, int k) {
5        if (nums == null || k <= 0) return new int[0];
6        int n = nums.length;
7        int[] result = new int[n - k + 1];
8        Deque<Integer> deque = new LinkedList<>(); // stores indices
9        
10        for (int i = 0; i < n; i++) {
11            // Remove indices out of the current window
12            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
13                deque.pollFirst();
14            }
15            
16            // Remove smaller values at the back
17            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
18                deque.pollLast();
19            }
20            
21            deque.offerLast(i);
22            
23            // Add max for current window
24            if (i >= k - 1) {
25                result[i - k + 1] = nums[deque.peekFirst()];
26            }
27        }
28        
29        return result;
30    }
31}
32