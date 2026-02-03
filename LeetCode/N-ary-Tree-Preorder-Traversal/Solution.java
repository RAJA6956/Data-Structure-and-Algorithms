1import java.util.*;
2
3class Solution {
4    public List<Integer> preorder(Node root) {
5        List<Integer> result = new ArrayList<>();
6        if (root == null) return result;
7
8        Stack<Node> stack = new Stack<>();
9        stack.push(root);
10
11        while (!stack.isEmpty()) {
12            Node node = stack.pop();
13            result.add(node.val);
14
15            // Push children in reverse order so leftmost comes first
16            List<Node> children = node.children;
17            for (int i = children.size() - 1; i >= 0; i--) {
18                stack.push(children.get(i));
19            }
20        }
21        return result;
22    }
23}
24