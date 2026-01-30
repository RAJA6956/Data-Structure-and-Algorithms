1public class Solution {
2     static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
3     static final String[] ROMANS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
4     static String intToRoman(int num) {
5        StringBuilder romanNumeral = new StringBuilder();
6        for (int i = 0; i < VALUES.length; i++) {
7            while (num >= VALUES[i]) {
8                romanNumeral.append(ROMANS[i]);
9                num -= VALUES[i];
10            }
11        }
12        return romanNumeral.toString();
13    }
14    public static void main(String[] args) {
15        int num1 = 3749;
16        int num2 = 58;
17        int num3 = 1994;
18        System.out.println(intToRoman(num1));
19        System.out.println(intToRoman(num2));
20        System.out.println(intToRoman(num3));
21    }
22}
23