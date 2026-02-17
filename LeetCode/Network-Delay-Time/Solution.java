class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int row= times.length;
        List<List<Pair>> adj= new ArrayList<>();
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->(a.weight-b.weight));
        boolean visited[]= new boolean[n+1];
        int count=0;
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<row;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair p= pq.remove();
            int curr=p.node;
            int wt=p.weight;
            if(!visited[curr]){
                count++;
                if(count==n){
                    return wt;
                }
                visited[curr]=true;
                for(Pair pr: adj.get(curr)){
                    if(!visited[pr.node]){
                        pq.add(new Pair(pr.node,pr.weight+wt));
                    }
                }
            }
        }

    return -1;
    }
}