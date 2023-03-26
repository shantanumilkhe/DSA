package Graph;

import java.util.ArrayList;
import java.util.Arrays;

//Approach:
//
//        The algorithm steps are as follows:
//
//        In the DFS function call make sure to store the parent data along with the
//        source node, create a visited array, and initialize to 0. The parent is stored
//        so that while checking for re-visited nodes, we don’t check for parents.

//        We run through all the unvisited adjacent nodes using an adjacency list and call
//        the recursive dfs function. Also, mark the node as visited.

//        If we come across a node that is already marked as visited and is not a parent node,
//        then keep on returning true indicating the presence of a cycle; otherwise return
//        false after all the adjacent nodes have been checked and we did not find a cycle.


// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total
// degrees as we traverse all adjacent nodes. In the case of connected
// components of a graph, it will take another O(N) time.
//
// Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space
// and visited array.

public class DetectCycleDFS {

    public static boolean DFS(int sr, int parent, ArrayList<ArrayList<Integer>> Graph, boolean[] visited){
        visited[sr] = true;
        for (int i: Graph.get(sr)){
            if(!visited[i]){
                 if(DFS(i, sr, Graph, visited)) return true;
            }
            else if(i!= parent) return true;
        }
        return false;
    }

    public static boolean detect(int V, ArrayList<ArrayList<Integer>> Graph){

        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        for(int i=0; i<V;i++) {
            if(!visited[i]){
                if(DFS(i, -1, Graph, visited)) return true;
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
