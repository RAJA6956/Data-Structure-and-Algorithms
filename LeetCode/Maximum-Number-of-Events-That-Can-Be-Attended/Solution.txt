1class Solution {
2    public int maxEvents(int[][] events) {
3        if (events == null || events.length == 0) return 0;
4        int N = events.length;
5
6        // array ko start day ke basis pr short kiya
7        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
8
9        // priority queue ko end day ke basis pr process krenge jisse short range ke events ko priority milegi 
10        PriorityQueue<Integer> pq = new PriorityQueue<>();
11
12        int i = 0, day = 0, answer = 0;
13        while (i < N || !pq.isEmpty()) {
14            if (pq.isEmpty()) {
15                day = events[i][0];
16            }
17            while (i < N && day == events[i][0]) {
18                pq.add(events[i][1]);
19                i++;
20            }
21            pq.poll();
22            answer++;
23            day++;
24
25            //jo events ki end day day counter se jyada - remove krna hai
26            while(!pq.isEmpty() && day> pq.peek()){
27                pq.poll();
28            }
29        }
30        return answer;
31            
32    }
33}