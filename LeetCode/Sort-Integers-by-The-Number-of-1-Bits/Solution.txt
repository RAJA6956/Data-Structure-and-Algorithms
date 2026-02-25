1class Solution {
2    public int[] sortByBits(int[] arr) {
3        java.util.TreeMap<Integer, java.util.PriorityQueue<Integer>> bitmap = new java.util.TreeMap<>();
4        
5        for (int val : arr) {
6            int bits = Integer.bitCount(val);
7            bitmap.putIfAbsent(bits, new java.util.PriorityQueue<>());
8            bitmap.get(bits).add(val);
9        }
10        
11        int[] ans = new int[arr.length];
12        int index = 0;
13        
14        for (int key : bitmap.keySet()) {
15            java.util.PriorityQueue<Integer> pq = bitmap.get(key);
16            while (!pq.isEmpty()) {
17                ans[index++] = pq.poll();
18            }
19        }
20        return ans;
21    }
22}