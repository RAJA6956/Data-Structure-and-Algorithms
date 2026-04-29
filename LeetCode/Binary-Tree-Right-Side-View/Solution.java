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
17    public List<Integer> rightSideView(TreeNode root) {
18        List<Integer> ans=new ArrayList<>();
19        if(root==null) return ans;
20
21        Queue<TreeNode> q=new LinkedList<>();
22        q.add(root);
23
24        while(! q.isEmpty()){
25            int size=q.size();
26            for(int i=0;i<size;i++){
27                TreeNode node=q.poll();
28                if(i==size-1) ans.add(node.val);
29
30                if(node.left != null) q.add(node.left);
31                if(node.right != null) q.add(node.right);
32            }
33        }
34        return ans;
35
36        
37    }
38}