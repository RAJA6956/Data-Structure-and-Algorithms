import java.util.*;

class Solution {
    class DisjointSet {
        int[] parent, size;
        DisjointSet(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int node) {
            if (parent[node] == node) return node;
            return parent[node] = find(parent[node]); // Path Compression
        }
        void union(int u, int v) {
            int pu = find(u), pv = find(v);
            if (pu == pv) return;
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0;
        for (int[] s : stones) {
            maxRow = Math.max(maxRow, s[0]);
            maxCol = Math.max(maxCol, s[1]);
        }

        // Offset columns to distinguish them from rows
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Set<Integer> stoneNodes = new HashSet<>();

        for (int[] s : stones) {
            int rowNode = s[0];
            int colNode = s[1] + maxRow + 1;
            ds.union(rowNode, colNode);
            stoneNodes.add(rowNode);
            stoneNodes.add(colNode);
        }

        int components = 0;
        for (int node : stoneNodes) {
            if (ds.find(node) == node) components++;
        }

        return stones.length - components;
    }
}
