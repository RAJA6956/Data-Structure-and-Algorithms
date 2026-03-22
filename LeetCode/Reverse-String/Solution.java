class Solution {
    //By recursion
    public static void reverseString(char[] s) {
         swap(s,0,s.length-1);
    }
    public static void swap(char[] s, int i, int j) {
        if (i >= j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        swap(s, i + 1, j - 1);
    }
    public static void main(String[] args){
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }
}