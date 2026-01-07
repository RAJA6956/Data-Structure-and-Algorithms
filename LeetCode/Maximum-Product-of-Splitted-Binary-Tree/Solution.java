1class Solution {
2    private long totalSum = 0;
3    private long maxProduct = 0;
4    private static final int MOD = 1_000_000_007;
5
6    public int maxProduct(TreeNode root) {
7        totalSum = treeSum(root);     // 1st DFS
8        subtreeSum(root);             // 2nd DFS
9        return (int)(maxProduct % MOD);
10    }
11
12    // Computes total sum of tree
13    private long treeSum(TreeNode node) {
14        if (node == null) return 0;
15        return node.val + treeSum(node.left) + treeSum(node.right);
16    }
17
18    // Computes subtree sums and max product
19    private long subtreeSum(TreeNode node) {
20        if (node == null) return 0;
21
22        long left = subtreeSum(node.left);
23        long right = subtreeSum(node.right);
24
25        long sub = node.val + left + right;
26        maxProduct = Math.max(maxProduct, sub * (totalSum - sub));
27
28        return sub;
29    }
30}
31