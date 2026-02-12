1class Solution {
2    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
3        Set<String> set = new HashSet<>(wordList);
4        if (!set.contains(endWord)) {
5            return 0;
6        }
7        Queue<String> q=new LinkedList<>();
8        q.add(beginWord);
9        int level=1; 
10        while (!q.isEmpty()) {
11            int size=q.size();
12            for (int i=0;i<size;i++) {
13                String word = q.poll();
14                char[] chars = word.toCharArray();
15
16                for(int j=0;j< chars.length;j++){
17                    char original = chars[j];
18
19                    for (char c = 'a'; c <= 'z'; c++) {
20                        chars[j] = c;
21                        String newWord = new String(chars);
22
23                        if (newWord.equals(endWord)) {
24                            return level+1;
25                        }
26                        if (set.contains(newWord)) {
27                            q.add(newWord);
28                            set.remove(newWord); 
29                        }
30                    }
31                    chars[j]=original;
32                }
33            }
34            level++;   
35        }
36        return 0;
37    }
38}