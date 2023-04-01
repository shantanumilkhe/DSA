package Graph;

import java.util.ArrayList;
import java.util.Arrays;

//        Approach:
//
//
//        We will be solving it using DFS traversal. DFS goes in-depth, i.e.,
//        traverses all nodes by going ahead, and when there are no further
//        nodes to traverse in the current path, then it backtracks on the
//        same path and traverses other unvisited nodes.
//
//        The algorithm steps are as follows:
//
//        We will traverse the graph component-wise using the DFS technique.

//        Make sure to carry two visited arrays in the DFS call. One is a visited
//        array(vis) and the other is a path-visited(pathVis) array. The visited
//        array keeps a track of visited nodes, and the path-visited keeps a
//        track of visited nodes in the current traversal only.

//        While making a DFS call, at first we will mark the node as visited in
//        both the arrays and then will traverse through its adjacent nodes. Now,
//        there may be either of the three cases:

//        Case 1: If the adjacent node is not visited, we will make a new DFS call
//        recursively with that particular node.
//        Case 2: If the adjacent node is visited and also on the same path
//        (i.e marked visited in the pathVis array), we will return true, because it
//        means it has a cycle, thereby the pathVis was true. Returning true will
//        mean the end of the function call, as once we have got a cycle, there is
//        no need to check for further adjacent nodes.
//        Case 3: If the adjacent node is visited but not on the same path
//        (i.e not marked in the pathVis array), we will continue to the next adjacent
//        node, as it would have been marked as visited in some other path, and not
//        on the current one.

//        Finally, if there are no further nodes to visit, we will unmark the current
//        node in the pathVis array and just return false. Then we will backtrack to
//        the previous node with the returned value. The point to remember is, while
//        we enter we mark both the pathVis and vis as true, but at the end of traversal
//        to all adjacent nodes, we just make sure we unmark the pathVis and still
//        keep the vis marked as true, as it will avoid future extra traversal calls.

//Time Complexity: O(V+E)+O(V) , where V = no. of nodes and E = no. of edges.
// There can be at most V components. So, another O(V) time complexity.
//
// Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for two visited arrays and O(N)
// for recursive stack space.
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
