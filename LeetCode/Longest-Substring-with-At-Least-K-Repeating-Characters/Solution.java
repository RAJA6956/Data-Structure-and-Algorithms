1class Solution {
2    public int longestSubstring(String s, int k) {
3        return helper(s, k);
4    }
5
6    private int helper(String s, int k) {
7        if (s.length() < k) return 0;
8
9        // Count frequency of each character
10        int[] freq = new int[26];
11        for (char c : s.toCharArray()) {
12            freq[c - 'a']++;
13        }
14
15        // Find a divider character
16        for (int i = 0; i < s.length(); i++) {
17            if (freq[s.charAt(i) - 'a'] < k) {
18                // Split around this character
19                int left = helper(s.substring(0, i), k);
20                int right = helper(s.substring(i + 1), k);
21                return Math.max(left, right);
22            }
23        }
24
25        // Every char occurs at least k times
26        return s.length();
27    }
28}
29