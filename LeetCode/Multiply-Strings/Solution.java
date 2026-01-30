1class Solution {
2    public String multiply(String num1, String num2) {
3        int m = num1.length(), n = num2.length();
4        int[] res = new int[m + n];
5        
6        for (int i = m - 1; i >= 0; i--) {
7            for (int j = n - 1; j >= 0; j--) {
8                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
9                int sum = mul + res[i + j + 1];
10                res[i + j + 1] = sum % 10;
11                res[i + j] += sum / 10;
12            }
13        }
14        
15        StringBuilder sb = new StringBuilder();
16        for (int num : res) {
17            if (!(sb.length() == 0 && num == 0)) sb.append(num);
18        }
19        return sb.length() == 0 ? "0" : sb.toString();
20    }
21}
22