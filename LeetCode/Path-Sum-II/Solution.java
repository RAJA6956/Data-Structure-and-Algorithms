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
17    List<List<Integer>> result=new ArrayList<>();
18    List<Integer> path=new ArrayList<>();
19
20    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
21        dfs(root,targetSum);
22        return result;
23        
24    }
25
26    public void dfs(TreeNode root,int sum){
27        if(root==null) return;
28        path.add(root.val);
29        if(root.left==null && root.right==null && root.val==sum){
30            result.add(new ArrayList<>(path));
31        }else{
32            dfs(root.left,sum-root.val);
33            dfs(root.right,sum-root.val);
34
35        }
36        path.remove(path.size()-1);
37
38    }
39}