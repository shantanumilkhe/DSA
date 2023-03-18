package Graph;

import java.util.ArrayList;

//Problem Statement: Given an undirected graph with V vertices.
// We say two vertices u and v belong to a single province if
// there is a path from u to v or v to u. Your task is to find
// the number of provinces.
//(in short, find number of connected components in the graph)
//Pre-req: Connected Components, Graph traversal techniques

//Approach:

// A province is a group of directly or indirectly connected cities
// and no other cities outside of the group. Considering the above
// example, we can go from 1 to 2 as well as to 3, from every other
// node in a province we can go to each other. As we cannot go from
// 2 to 4 so it is not a province. We know about both the traversals,
// Breadth First Search (BFS) and Depth First Search (DFS). We can use
// any of the traversals to solve this problem because a traversal
// algorithm visits all the nodes in a graph. In any traversal technique,
// we have one starting node and it traverses all the nodes in the graph.
// Suppose there is an ‘N’ number of provinces so we need to call the traversal
// algorithm ‘N‘ times, i.e., there will be ‘N’ starting nodes. So, we just need
// to figure out the number of starting nodes.

//The algorithm steps are as follows:
//
//        We need a visited array initialized to 0, representing the nodes that are not visited.

//        Run the for loop looping from 0 to N, and call the DFS for the first unvisited node.

//        DFS function call will make sure that it starts the DFS call from that unvisited node,
//        and visits all the nodes that are in that province, and at the same time, it will also
//        mark them as visited.

//        Since the nodes traveled in a traversal will be marked as visited, they will no further be
//        called for any further DFS traversal.

//        Keep repeating these steps, for every node that you find unvisited, and visit the entire province.

//        Add a counter variable to count the number of times the DFS function is called, as in
//        this way we can count the total number of starting nodes, which will give us the number
//        of provinces.
public class Provinces {
    public static void recPro(int curNode, boolean vis[], ArrayList<ArrayList<Integer>> Graph){

        vis[curNode] = true;

        for(int i: Graph.get(curNode)){
            if(!vis[i]){
                recPro(i, vis, Graph);
            }
        }
    }
    public static int pro(int V, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V];

        int count = 0;

        for(int i =0; i<V; i++){
            if(!vis[i]){
                count++;
                recPro(i, vis, adj );
            }
        }
        return count;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer> >();

        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);

        System.out.println(pro(3, adj));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
