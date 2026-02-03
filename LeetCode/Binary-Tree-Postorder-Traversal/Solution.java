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
16import java.util.*;
17
18class Solution {
19    public List<Integer> postorderTraversal(TreeNode root) {
20        LinkedList<Integer> result = new LinkedList<>();
21        if (root == null) return result;
22
23        Stack<TreeNode> stack = new Stack<>();
24        stack.push(root);
25
26        while (!stack.isEmpty()) {
27            TreeNode node = stack.pop();
28            result.addFirst(node.val); // add to front (reverses order)
29
30            if (node.left != null) stack.push(node.left);
31            if (node.right != null) stack.push(node.right);
32        }
33        return result;
34    }
35}
36