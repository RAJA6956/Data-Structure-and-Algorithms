1class Solution {
2    public String reverseVowels(String s) {
3        Set<Character> vowels = Set.of('a','e','i','o','u','A','E','I','O','U');
4        char[] arr = s.toCharArray();
5        int left = 0, right = arr.length - 1;
6        while (left < right) {
7            while (left < right && !vowels.contains(arr[left])) left++;
8            while (left < right && !vowels.contains(arr[right])) right--;
9            if (left < right) {
10                char temp = arr[left];
11                arr[left] = arr[right];
12                arr[right] = temp;
13                left++;
14                right--;
15            }
16        }
17        return new String(arr);
18    }
19}
20