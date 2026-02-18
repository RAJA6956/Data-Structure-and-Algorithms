1class Solution {
2
3    static class Pair implements Comparable<Pair> {
4        int node;
5        long time;
6
7        Pair(int node, long time) {
8            this.node = node;
9            this.time = time;
10        }
11
12        public int compareTo(Pair other) {
13            return Long.compare(this.time, other.time);
14        }
15    }
16
17    public int countPaths(int n, int[][] roads) {
18        int MOD = 1_000_000_007;
19        ArrayList<ArrayList<Pair>> list=new ArrayList<>();
20        for (int i=0;i < n;i++) {
21            list.add(new ArrayList<>());
22        }
23        for (int[] edge:roads) {
24            list.get(edge[0]).add(new Pair(edge[1], edge[2]));
25            list.get(edge[1]).add(new Pair(edge[0], edge[2]));
26        }
27        long[] dist=new long[n];
28        long[] ways=new long[n];
29        Arrays.fill(dist,Long.MAX_VALUE);
30        PriorityQueue<Pair> pq=new PriorityQueue<>();
31        dist[0] = 0;
32        ways[0] = 1;
33        pq.add(new Pair(0, 0));
34        while (!pq.isEmpty()) {
35            Pair curr = pq.poll();
36            int node=curr.node;
37            long time=curr.time;
38            if (time > dist[node]) continue;
39            for (Pair neighbor:list.get(node)) {
40                long newTime=time+neighbor.time;
41                if (newTime<dist[neighbor.node]) {
42                    dist[neighbor.node] = newTime;
43                    ways[neighbor.node] = ways[node];
44                    pq.add(new Pair(neighbor.node, newTime));
45                }
46                else if(newTime == dist[neighbor.node]) {
47                    ways[neighbor.node] =(ways[neighbor.node] + ways[node]) % MOD;
48                }
49            }
50        }
51
52        return(int)ways[n - 1];
53    }
54}
55