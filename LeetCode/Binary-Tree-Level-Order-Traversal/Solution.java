class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            
            while (size > 0) {
                TreeNode node = queue.poll();
                
                // Add children to the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                
                // Collect node value for current level
                list.add(node.val);
                size--;
            }
            // Add finished level to result
            res.add(list);
        }
        return res;
    }
}