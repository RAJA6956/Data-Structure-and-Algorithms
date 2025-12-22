1class Solution {
2    public int largestAltitude(int[] gain) {
3        ArrayList <Integer> temp=new ArrayList<>();
4        temp.add(0);
5        int sum=0;
6        for(int i=0;i< gain.length;i++){
7            sum +=gain[i];
8            temp.add(sum);
9
10        }
11        return Collections.max(temp);
12
13        
14    }
15}