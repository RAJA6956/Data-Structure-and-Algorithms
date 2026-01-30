1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        Map<String, List<String>> map = new HashMap<>();
4        for (String s : strs) {
5            char[] arr = s.toCharArray();
6            Arrays.sort(arr);
7            String key = new String(arr);
8            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
9        }
10        return new ArrayList<>(map.values());
11    }
12}
13