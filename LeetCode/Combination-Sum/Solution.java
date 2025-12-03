1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> combinationSum(int[] candidates, int target) {
5        List<List<Integer>> result = new ArrayList<>();
6        Arrays.sort(candidates); // optional but helps optimize
7        backtrack(candidates, target, 0, new ArrayList<>(), result);
8        return result;
9    }
10
11    private void backtrack(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
12        if (target == 0) {
13            // Found a valid combination
14            result.add(new ArrayList<>(combination));
15            return;
16        }
17
18        for (int i = start; i < candidates.length; i++) {
19            if (candidates[i] > target) {
20                // No need to continue; array is sorted
21                break;
22            }
23
24            // Choose the candidate
25            combination.add(candidates[i]);
26
27            // Recurse with the same index 'i' because we can reuse same element
28            backtrack(candidates, target - candidates[i], i, combination, result);
29
30            // Backtrack
31            combination.remove(combination.size() - 1);
32        }
33    }
34}
35