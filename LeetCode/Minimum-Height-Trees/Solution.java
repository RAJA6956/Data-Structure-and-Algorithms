class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] frq = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        int[] ans = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] i : edges) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
            frq[i[0]]++;
            frq[i[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (frq[i] == 1) {
                q.add(i);
                ans[i] = 1;
                max = Math.max(max, ans[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int top = q.poll();
            for (int i : graph.get(top)) {
                if (frq[i] > 1) {
                    frq[i]--;
                    if (frq[i] == 1) {
                        q.add(i);
                        ans[i] = ans[top] + 1;
                        max = Math.max(max, ans[i]);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ans[i] == max) {
                result.add(i);
            }
        }
        return result;
    }

}