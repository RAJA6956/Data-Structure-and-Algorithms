1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int minDepth(TreeNode root) {
18        if (root == null) return 0;
19
20        Queue<TreeNode> q = new LinkedList<>();
21        q.offer(root);
22        int depth = 1;
23
24        while (!q.isEmpty()) {
25            int size = q.size();
26            for (int i = 0; i < size; i++) {
27                TreeNode node = q.poll();
28
29                // if it's a leaf, we found our exit — time to leave the forest
30                if (node.left == null && node.right == null) {
31                    return depth;
32                }
33
34                if (node.left != null) q.offer(node.left);
35                if (node.right != null) q.offer(node.right);
36            }
37            depth++;
38        }
39
40        return depth;
41    }
42}