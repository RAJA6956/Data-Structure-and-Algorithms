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
18        List<Integer> res=new ArrayList<>();
19        
20        if (root == null) return res;
21        Queue<TreeNode> queue = new ArrayDeque<>();
22        queue.add(root);
23        while (!queue.isEmpty()) {
24            int size = queue.size();
25            while (size > 0) {
26                TreeNode node = queue.poll();
27                if(size==1) res.add(node.val);
28                if (node.left != null) queue.add(node.left);
29                if (node.right != null) queue.add(node.right);
30                size--;
31            }
32        }
33        return res;
34
35        
36    }
37}
38
39
40
41
42