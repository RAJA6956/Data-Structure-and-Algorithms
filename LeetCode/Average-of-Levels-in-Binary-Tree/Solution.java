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
17    public List<Double> averageOfLevels(TreeNode root) {
18        List<Double> res=new ArrayList<>();
19        
20        if (root == null) return res;
21        Queue<TreeNode> queue = new ArrayDeque<>();
22        queue.add(root);
23        while (!queue.isEmpty()) {
24            int size = queue.size();
25            double sum=0;
26            double temp=size;
27            while (size > 0) {
28                TreeNode node = queue.poll();
29                sum +=node.val;
30                if (node.left != null) queue.add(node.left);
31                if (node.right != null) queue.add(node.right);
32                size--;
33                if(size==0){
34                    res.add(sum/temp);
35                }
36            }
37            
38        }
39        return res;
40        
41    }
42}
43
44
45