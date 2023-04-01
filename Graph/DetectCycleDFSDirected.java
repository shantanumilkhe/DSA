package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DetectCycleDFSDirected {

    public static boolean DFS(int sr, int parent, ArrayList<ArrayList<Integer>> Graph,
                              boolean[] visited, boolean[]pathvis){
        visited[sr] = true;
        pathvis[sr] = true;


        for (int i: Graph.get(sr)){
            if(!visited[i]){
                 if(DFS(i, sr, Graph, visited, pathvis)) return true;
            }
            else if(pathvis[i]) return true;
        }
        pathvis[sr]=false;
        return false;
    }


    public static boolean detect(int V, ArrayList<ArrayList<Integer>> Graph){

        boolean[] visited = new boolean[V];
        boolean[] pathvis = new boolean[V];
        Arrays.fill(visited, false);
        for(int i=0; i<V;i++) {
            if(!visited[i]){
                if(DFS(i, -1, Graph, visited, pathvis)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
//       adj.get(0).add(1);
//       adj.get(1).add(0);
//       adj.get(1).add(2);
//       adj.get(1).add(4);
//       adj.get(2).add(1);
//       adj.get(2).add(3);
//       adj.get(3).add(2);
//       adj.get(3).add(4);
//       adj.get(4).add(1);
//       adj.get(4).add(3);

        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        System.out.println( detect(4,adj));


        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
