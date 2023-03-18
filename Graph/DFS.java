package Graph;

import java.util.ArrayList;
import java.util.Stack;

//Approach:
//
//        DFS is a traversal technique which involves the idea of recursion and backtracking.
//        DFS goes in-depth, i.e., traverses all nodes by going ahead, and when there are no
//        further nodes to traverse in the current path, then it backtracks on the same path
//        and traverses other unvisited nodes.
//
//        In DFS, we start with a node ‘v’, mark it as visited and store it in the solution vector.
//        It is unexplored as its adjacent nodes are not visited.

//        We run through all the adjacent nodes, and call the recursive dfs function to explore the
//        node ‘v’ which has not been visited previously. This leads to the exploration of another
//        node ‘u’ which is its adjacent node and is not visited.

//        The adjacency list stores the list of neighbours for any node. Pick the neighbour list of
//        node ‘v’ and run a for loop on the list of neighbours (say nodes ‘u’ and ‘w’ are in the list).
//        We go in-depth with each node. When node ‘u’ is explored completely then it backtracks and
//        explores node ‘w’.

//        This traversal terminates when all the nodes are completely explored.


// Time Complexity: For an undirected graph, O(N) + O(2E), For a directed graph,
// O(N) + O(E), Because for every node we are calling the recursive function once,
// the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.
//
// Space Complexity: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.

public class DFS {

    public static void recDFS(int curNode, boolean vis[], ArrayList<ArrayList<Integer>> Graph, ArrayList<Integer> list){

        list.add(curNode);
        vis[curNode] = true;

        for(int i: Graph.get(curNode)){
            if(!vis[i]){
                recDFS(i, vis, Graph, list);
            }
        }
    }


    public static ArrayList<Integer> DFSof(int V, ArrayList<ArrayList<Integer>> Graph){

        ArrayList<Integer> list = new ArrayList<>();
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        visited[0] = true;
        recDFS(0, visited, Graph, list);
        return list;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        DFS d1 = new DFS();
        ArrayList < Integer > ans = d1.DFSof(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
