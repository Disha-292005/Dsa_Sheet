class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        int[] indegree=new int[n];
        for(int i=0;i<prerequisites.length;i++)
        {
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
            q.offer(i);
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int neighbour:adj.get(cur)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0)q.offer(neighbour);
            }
        }
        for(int i=0;i<n;i++){
            if(indegree[i]!=0)return false;
           
        }
         return true;
    }
}
