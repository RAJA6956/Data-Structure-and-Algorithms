1import java.util.LinkedList;
2import java.util.Queue;
3
4class MyStack {
5    private Queue<Integer> q = new LinkedList<>();
6
7    public void push(int x) {
8        q.offer(x);
9        // Rotate the queue so that the new element is at the front
10        for (int i = 0; i < q.size() - 1; i++) {
11            q.offer(q.poll());
12        }
13    }
14
15    public int pop() {
16        return q.poll();
17    }
18
19    public int top() {
20        return q.peek();
21    }
22
23    public boolean empty() {
24        return q.isEmpty();
25    }
26}
27