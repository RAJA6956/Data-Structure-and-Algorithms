1class Solution {
2  public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
3    List<Integer>[] graph = new List[n];
4
5    for (int i = 0; i < n; i++)
6      graph[i] = new ArrayList<>();
7
8    for (int[] edge : edges) {
9      final int u = edge[0];
10      final int v = edge[1];
11      graph[u].add(v);
12      graph[v].add(u);
13    }
14
15    dfs(graph, 0, /*prev=*/-1, values, k);
16    return ans;
17  }
18
19  private int ans = 0;
20
21  private long dfs(List<Integer>[] graph, int u, int prev, int[] values, int k) {
22    long treeSum = values[u];
23
24    for (int v : graph[u])
25      if (v != prev)
26        treeSum += dfs(graph, v, u, values, k);
27
28    if (treeSum % k == 0)
29      ++ans;
30    return treeSum;
31  }
32}