1class Solution {
2
3    public int findCenter(int[][] edges) {
4        Map<Integer, Integer> degree = new HashMap<>();
5
6        for (int[] edge : edges) {
7            degree.put(edge[0], degree.getOrDefault(edge[0], 0) + 1);
8            degree.put(edge[1], degree.getOrDefault(edge[1], 0) + 1);
9        }
10
11        for (int node : degree.keySet()) {
12            if (degree.get(node) == edges.length) {
13                return node;
14            }
15        }
16
17        return -1;
18    }
19}