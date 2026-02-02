1import java.util.*;
2
3public class Solution {
4    public List<Integer> findSubstring(String s, String[] words) {
5        List<Integer> result = new ArrayList<>();
6        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;
7
8        int wordLen = words[0].length();
9        int totalLen = wordLen * words.length;
10
11        // Frequency map of the given words
12        Map<String, Integer> wordCount = new HashMap<>();
13        for (String w : words) {
14            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
15        }
16
17        // We check windows starting at each offset within a word length
18        for (int i = 0; i < wordLen; i++) {
19            int left = i, right = i;
20            Map<String, Integer> windowCount = new HashMap<>();
21            int count = 0; // number of valid words in current window
22
23            while (right + wordLen <= s.length()) {
24                String word = s.substring(right, right + wordLen);
25                right += wordLen;
26
27                if (wordCount.containsKey(word)) {
28                    windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
29                    count++;
30
31                    // If a word occurs more times than needed, shrink window
32                    while (windowCount.get(word) > wordCount.get(word)) {
33                        String leftWord = s.substring(left, left + wordLen);
34                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
35                        left += wordLen;
36                        count--;
37                    }
38
39                    // If we matched all words, record start index
40                    if (count == words.length) {
41                        result.add(left);
42                    }
43                } else {
44                    // Reset window if invalid word found
45                    windowCount.clear();
46                    count = 0;
47                    left = right;
48                }
49            }
50        }
51        return result;
52    }
53}
54