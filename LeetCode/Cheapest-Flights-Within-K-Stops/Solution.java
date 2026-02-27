1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3        List<List<int[]>> adj = new ArrayList<>();
4        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
5        for (int[] flight : flights) {
6            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
7        }
8        Queue<int[]> q = new LinkedList<>();
9        q.offer(new int[] {src, 0});
10        int[] minCost = new int[n];
11        Arrays.fill(minCost, Integer.MAX_VALUE);
12        int stops = 0;
13        while (!q.isEmpty() && stops <= k) {
14            int size = q.size();
15            while (size-- > 0) {
16                int[] curr = q.poll();
17                for (int[] neighbour : adj.get(curr[0])) {
18                    int price = neighbour[1], neighbourNode = neighbour[0];
19                    if (price + curr[1] >= minCost[neighbourNode]) continue;
20                    minCost[neighbourNode] = price + curr[1];
21                    q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
22                }
23            }
24            stops++;
25        }
26        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
27    }
28}