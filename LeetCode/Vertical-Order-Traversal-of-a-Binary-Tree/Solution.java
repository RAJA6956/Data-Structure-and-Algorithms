/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class tuple{
            TreeNode node;
            int row;
            int col;
            tuple (TreeNode n,int r, int c){
                node = n;
                row =r;
                col = c;
            }
        }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<tuple> queue = new LinkedList<>();

        queue.offer(new tuple(root,0,0));

        while(!queue.isEmpty()){
            tuple t = queue.poll();
            TreeNode node = t.node;
            int row=t.row;
            int col =t.col;
            map.putIfAbsent(col,new TreeMap());
            map.get(col).putIfAbsent(row,new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);
            if (node.left != null) {
                queue.offer(new tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new tuple(node.right, row + 1, col + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()){
                while (!nodes.isEmpty()){
                    col.add(nodes.poll());
                }
            }
            result.add(col);
        }
        return result;

    }
}