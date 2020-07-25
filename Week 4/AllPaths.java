class Solution {
    //SOLTION 1: DFS
    public void getPath(int[][] graph, int i, int dest, List<Integer> path, List<List<Integer>> res){
        if(i==dest){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int adj:graph[i]){
            path.add(adj);
            getPath(graph, adj, dest, path, res);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        if(graph.length==0 || graph==null)
            return res;
        List<Integer> path=new ArrayList<>();
        path.add(0);
        getPath(graph, 0, graph.length-1, path, res);
        return res;
    }
}
