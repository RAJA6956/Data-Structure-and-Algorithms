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
17
18    public boolean check(TreeNode left, TreeNode right){
19
20        if(left == null && right == null) return true;
21
22        if(left == null || right == null) return false;
23
24        if(left.val != right.val) return false;
25
26        boolean leftval = check(left.right, right.left);
27        boolean rightval = check(left.left, right.right);
28
29        return leftval && rightval;
30    }
31
32    public boolean isSymmetric(TreeNode root) {
33
34        if(root == null) return true;
35
36        return check(root.left, root.right);
37    }
38}