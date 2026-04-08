1// Sort + PriorityQueue Solution
2// 1. Sort events by start day
3// 2. Store end days of in progress events in min heap
4// 3. Join the earliest ending in progress evetns from the earliest start event to the latest start evetn.
5//    1) Get current date
6//    2) Add just started events at current day in the min heap
7//    3) Join the earliest ending event
8//    4) Remove already ended events
9// 4. Do the loop until we explore all the events and the min heap is empty.
10// Time complexity: O(NlogN)
11// Space complexity: O(N)
12class Solution {
13    public int maxEvents(int[][] events) {
14        if (events == null || events.length == 0) return 0;
15        final int N = events.length;
16        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
17        PriorityQueue<Integer> pq = new PriorityQueue<>();
18        int i = 0, day = 0, answer = 0;
19        while (i < N || !pq.isEmpty()) {
20            if (pq.isEmpty()) {
21                day = events[i][0];
22            }
23            while (i < N && day == events[i][0]) {
24                pq.add(events[i][1]);
25                i++;
26            }
27            pq.poll();
28            answer++;
29            day++;
30            //jo events ki end day day counter se jyada - remove krna hai
31            while (!pq.isEmpty() && day > pq.peek()) {
32                pq.poll();
33            }
34        }
35        return answer;
36    }
37}