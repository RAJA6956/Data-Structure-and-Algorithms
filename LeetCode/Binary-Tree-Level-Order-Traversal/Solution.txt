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
17    public List<List<Integer>> levelOrder(TreeNode root) {
18        List<List<Integer>> lis=new ArrayList<>();
19
20        if(root==null) return lis;
21        Queue<TreeNode> q=new LinkedList<>();
22        q.offer(root);
23        while(!q.isEmpty()){
24            int size=q.size();
25            List<Integer> l=new ArrayList<>();
26            while(size>0){
27                TreeNode node=q.poll();
28                l.add(node.val);
29                if(node.left != null) q.offer(node.left);
30                if(node.right != null) q.offer(node.right);
31                size--;
32
33
34            }
35            lis.add(l);
36        }
37        return lis;
38        
39    }
40}