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
17    int diameter=0;
18    public int diameterOfBinaryTree(TreeNode root) {
19        dfs(root);
20        return diameter;
21        
22    }
23    public int dfs(TreeNode root){
24        if(root==null) return 0;
25        int left=dfs(root.left);
26        int right=dfs(root.right);
27        diameter=Math.max(diameter,left+right);
28        return 1+Math.max(left,right);
29    }
30}