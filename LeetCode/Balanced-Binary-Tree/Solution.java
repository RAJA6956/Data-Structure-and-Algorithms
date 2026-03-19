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
17    public boolean isBalanced(TreeNode root) {
18        if (root==null) return true;
19        int left=height(root.left);
20        int right=height(root.right);
21        if(Math.abs(left-right)>1) return false;
22        return isBalanced(root.left) && isBalanced(root.right);
23
24        
25    }
26    public int height(TreeNode root){
27        if(root==null) return 0;
28        int left=height(root.left);
29        int right=height(root.right);
30        return 1+Math.max(left,right);
31
32    }
33}