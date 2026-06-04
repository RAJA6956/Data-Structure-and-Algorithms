1class Solution {
2    public int totalWaviness(int num1, int num2) {
3        int ans=0;
4        for(int i=num1;i<=num2;i++ ){
5            String s=String.valueOf(i);
6            for(int x=1;x<s.length()-1;x++){
7                if((s.charAt(x) > s.charAt(x - 1) && s.charAt(x) > s.charAt(x + 1) ) ||  (s.charAt(x) < s.charAt(x - 1) && s.charAt(x) < s.charAt(x + 1))) {
8                    ans +=1;
9                }
10            }
11        }
12        return ans;
13        
14    }
15}
16
17
18