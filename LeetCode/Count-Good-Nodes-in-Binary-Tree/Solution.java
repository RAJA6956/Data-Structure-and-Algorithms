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
17    int count;
18    public int goodNodes(TreeNode root) {
19        int maxInRoute=Integer.MIN_VALUE;
20        count=0;
21        dfs(root,maxInRoute);
22        return count;
23        
24    }
25    public void dfs(TreeNode root,int max){
26        if(root==null) return;
27        if(root.val>=max){
28            count++;
29
30        }
31        dfs(root.left,Math.max(max,root.val));
32        dfs(root.right,Math.max(max,root.val));
33    }
34}