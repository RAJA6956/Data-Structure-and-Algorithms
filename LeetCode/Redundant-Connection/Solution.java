1class Solution {
2
3    public int[] findRedundantConnection(int[][] edges) {
4
5        int n = edges.length;
6        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
7
8        for (int i = 0; i <= n; i++) {
9            graph.add(new ArrayList<>());
10        }
11
12        for (int[] edge : edges) {
13
14            int u = edge[0];
15            int v = edge[1];
16
17            boolean[] visited = new boolean[n + 1];
18
19            if (!graph.get(u).isEmpty() &&
20                !graph.get(v).isEmpty() &&
21                dfs(u, v, graph, visited)) {
22                return edge;
23            }
24
25            graph.get(u).add(v);
26            graph.get(v).add(u);
27        }
28
29        return new int[0];
30    }
31
32    private boolean dfs(int src, int target,
33                        ArrayList<ArrayList<Integer>> graph,
34                        boolean[] visited) {
35
36        if (src == target) return true;
37
38        visited[src] = true;
39
40        for (int neighbor : graph.get(src)) {
41            if (!visited[neighbor]) {
42                if (dfs(neighbor, target, graph, visited))
43                    return true;
44            }
45        }
46
47        return false;
48    }
49}