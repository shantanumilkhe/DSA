package Graph.Topological;

import java.util.ArrayList;
import java.util.Stack;

//Topological sorting only exists in Directed Acyclic Graph (DAG).
// If the nodes of a graph are connected through directed edges and
// the graph does not contain a cycle, it is called a directed acyclic graph(DAG).
//
//The topological sorting of a directed acyclic graph is nothing but the
// linear ordering of vertices such that if there is an edge between node
// u and v(u -> v), node u appears before v in that ordering.

//Approach:
//
//        We will be solving it using the DFS traversal technique.
//        DFS goes in-depth, i.e., traverses all nodes by going ahead,
//        and when there are no further nodes to traverse in the current path,
//        then it backtracks on the same path and traverses other unvisited nodes.
//
//        The algorithm steps are as follows:
//
//        We must traverse all components of the graph.

//        Make sure to carry a visited array(all elements are initialized to 0) and
//        a stack data structure, where we are going to store the nodes after completing
//        the DFS call.

//        In the DFS call, first, the current node is marked as visited. Then DFS call is
//        made for all its adjacent nodes.

//        After visiting all its adjacent nodes, DFS will backtrack to the previous node
//        and meanwhile, the current node is pushed into the stack.

//        Finally, we will get the stack containing one of the topological sortings of
//        the graph.

//Intuition:
//
//        Since we are inserting the nodes into the stack after the completion of the
//        traversal, we are making sure, there will be no one who appears afterward but
//        may come before in the ordering as everyone during the traversal would have
//        been inserted into the stack.

// Time Complexity: O(V+E)+O(V), where V = no. of nodes and E = no. of edges. There
// can be at most V components. So, another O(V) time complexity.
//
// Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for the visited array and the stack
// carried during DFS calls and O(N) for recursive stack space, where N = no. of nodes.

public class topologicalSort {
    public static void dfs(int node,  ArrayList<ArrayList<Integer>> adj, boolean[] visited,
                           Stack<Integer> st){
        visited[node]= true;
        for(int i: adj.get(node)){
            if(!visited[i]){
                dfs(i, adj, visited, st);
            }
        }
        st.push(node);
    }

    public static void topological(int V,  ArrayList<ArrayList<Integer>> adj){

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i =0; i<V; i++){
           if(!visited[i]) dfs(i, adj, visited, st);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        topological(V, adj);


        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
