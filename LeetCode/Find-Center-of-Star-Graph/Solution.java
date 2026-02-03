1/// do with adjacensy matrix - will give tle and mle
2
3// class Solution {
4//     public int findCenter(int[][] edges) {
5//         int n = edges.length + 1;
6//         int[][] graph1 = new int[n + 1][n + 1];
7
8//         for (int[] e : edges) {
9//             graph1[e[0]][e[1]] = 1;
10//             graph1[e[1]][e[0]] = 1;
11//         }
12
13//         for (int i = 1; i <= n; i++) {
14//             int degree = 0;
15//             for (int j = 1; j <= n; j++) {
16//                 degree += graph1[i][j];
17//             }
18//             if (degree == n - 1) return i;
19//         }
20//         return -1;
21//     }
22// }
23
24
25
26// do with adjacency list
27class Solution {
28    public int findCenter(int[][] edges) {
29        int n=edges.length + 1;
30        List<Integer>[] graph1 = new ArrayList[n + 1];
31        for (int i = 1; i <= n; i++) graph1[i] = new ArrayList<>();
32        for (int[] e : edges) {
33            graph1[e[0]].add(e[1]);
34            graph1[e[1]].add(e[0]);
35        }
36        for (int i = 1; i <= n; i++) {
37            if (graph1[i].size() == n - 1) return i;
38        }
39        return -1;
40    }
41}
42