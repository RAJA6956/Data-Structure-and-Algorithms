1import java.util.*;
2
3public class Solution {
4    public List<String> findRepeatedDnaSequences(String s) {
5        Set<String> seen = new HashSet<>();
6        Set<String> repeated = new HashSet<>();
7        
8        for (int i = 0; i + 10 <= s.length(); i++) {
9            String sub = s.substring(i, i + 10);
10            if (!seen.add(sub)) {        // if already in seen, it's repeated
11                repeated.add(sub);
12            }
13        }
14        return new ArrayList<>(repeated);
15    }
16}
17