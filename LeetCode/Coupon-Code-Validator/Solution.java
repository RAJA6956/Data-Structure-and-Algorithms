1class Solution {
2    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
3        int n = code.length;
4        List<String> electronics = new ArrayList<>();
5        List<String> grocery = new ArrayList<>();
6        List<String> pharmacy = new ArrayList<>();
7        List<String> restaurant = new ArrayList<>();
8        for (int i = 0; i < n; i++) {
9            if (!isActive[i]) continue;
10            if (code[i] == null || code[i].isEmpty()) continue;
11
12            boolean valid = true;
13            for (char c : code[i].toCharArray()) {
14                if (!Character.isLetterOrDigit(c) && c != '_') {
15                    valid = false;
16                    break;
17                }
18            }
19            if (!valid) continue;
20            switch (businessLine[i]) {
21                case "electronics":
22                    electronics.add(code[i]);
23                    break;
24                case "grocery":
25                    grocery.add(code[i]);
26                    break;
27                case "pharmacy":
28                    pharmacy.add(code[i]);
29                    break;
30                case "restaurant":
31                    restaurant.add(code[i]);
32                    break;
33            }
34        }
35        Collections.sort(electronics);
36        Collections.sort(grocery);
37        Collections.sort(pharmacy);
38        Collections.sort(restaurant);
39        List<String> result = new ArrayList<>();
40        result.addAll(electronics);
41        result.addAll(grocery);
42        result.addAll(pharmacy);
43        result.addAll(restaurant);
44
45        return result;
46    }
47}