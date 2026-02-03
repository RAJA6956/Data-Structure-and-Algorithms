1/// do with adjacensy matrix - will give tle and mle
2
3
4// our main concept is star node is node which connect with n-1 nodes or edges
5
6
7// class Solution {
8//     public int findCenter(int[][] edges) {
9//         int n = edges.length + 1;
10//         int[][] graph1 = new int[n + 1][n + 1];
11
12//         for (int[] e : edges) {
13//             graph1[e[0]][e[1]] = 1;
14//             graph1[e[1]][e[0]] = 1;
15//         }
16
17//         for (int i = 1; i <= n; i++) {
18//             int degree = 0;
19//             for (int j = 1; j <= n; j++) {
20//                 degree += graph1[i][j];
21//             }
22//             if (degree == n - 1) return i;
23//         }
24//         return -1;
25//     }
26// }
27
28
29
30// do with adjacency list  O(n) for both space and time
31// class Solution {
32//     public int findCenter(int[][] edges) {
33//         int n=edges.length + 1;
34//         List<Integer>[] graph1 = new ArrayList[n + 1];
35//         for (int i = 1; i <= n; i++) graph1[i] = new ArrayList<>();
36//         for (int[] e : edges) {
37//             graph1[e[0]].add(e[1]);
38//             graph1[e[1]].add(e[0]);
39//         }
40//         for (int i = 1; i <= n; i++) {
41//             if (graph1[i].size() == n - 1) return i;
42//         }
43//         return -1;
44//     }
45//}
46
47
48// do with in-degree
49class Solution {
50    public int findCenter(int[][] edges) {
51        int n = edges.length + 1;
52        int[] indegree = new int[n + 1];
53
54        for (int[] e : edges) {
55            indegree[e[0]]++;
56            indegree[e[1]]++;
57        }
58
59        for (int i = 1; i <= n; i++) {
60            if (indegree[i] == n - 1) return i;
61        }
62        return -1;
63    }
64}
65