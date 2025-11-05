import java.util.*;

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        Map<Integer, Integer> cnt = new HashMap<>();
        Comparator<long[]> cmp = (a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        };
        TreeSet<long[]> top = new TreeSet<>(cmp);
        TreeSet<long[]> rest = new TreeSet<>(cmp);
        long topSum = 0;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            int old = cnt.getOrDefault(v, 0);
            if (old > 0) {
                long[] node = new long[]{old, v};
                if (!rest.remove(node)) {
                    if (top.remove(node)) topSum -= node[0] * node[1];
                }
            }
            int nw = old + 1;
            cnt.put(v, nw);
            long[] newNode = new long[]{nw, v};
            rest.add(newNode);
            if (i >= k) {
                int out = nums[i - k];
                int oldOut = cnt.get(out);
                long[] node = new long[]{oldOut, out};
                if (!rest.remove(node)) {
                    if (top.remove(node)) topSum -= node[0] * node[1];
                }
                if (oldOut == 1) cnt.remove(out);
                else {
                    cnt.put(out, oldOut - 1);
                    long[] newOut = new long[]{oldOut - 1, out};
                    rest.add(newOut);
                }
            }
            if (i >= k - 1) {
                while (top.size() < x && !rest.isEmpty()) {
                    long[] move = rest.pollLast();
                    top.add(move);
                    topSum += move[0] * move[1];
                }
                while (top.size() > x) {
                    long[] drop = top.pollFirst();
                    topSum -= drop[0] * drop[1];
                    rest.add(drop);
                }
                if (!top.isEmpty() && !rest.isEmpty()) {
                    while (true) {
                        long[] worstTop = top.first();
                        long[] bestRest = rest.last();
                        if (cmp.compare(bestRest, worstTop) > 0) {
                            top.remove(worstTop);
                            rest.remove(bestRest);
                            topSum -= worstTop[0] * worstTop[1];
                            top.add(bestRest);
                            topSum += bestRest[0] * bestRest[1];
                            rest.add(worstTop);
                        } else break;
                    }
                }
                ans[i - k + 1] = topSum;
            }
        }
        return ans;
    }
}
