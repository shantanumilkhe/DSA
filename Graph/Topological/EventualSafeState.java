package Graph.Topological;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//Approach:

//A terminal node is a node without any outgoing edges(i.e outdegree = 0).
// Now a node is considered to be a safe node if all possible paths starting
// from it lead to a terminal node. Here we need to find out all safe nodes
// and return them sorted in ascending order. If we closely observe,
// all possible paths starting from a node are going to end at some terminal
// node unless there exists a cycle and the paths return back to themselves.
// Let’s understand it considering the below graph:
//
//    In the above graph, there exists a cycle i.e 0->1->3->0, and node 7 is
//    connected to the cycle with an incoming edge towards the cycle.

//    Some paths starting from these nodes are definitely going to end somewhere
//    in the cycle and not at any terminal node. So, these nodes are not safe nodes.

//    Though node 2 is connected to the cycle, the edge is directed outwards the
//    cycle and all the paths starting from it lead to the terminal node 5. So, it
//    is a safe node and the rest of the nodes (4, 5, 6) are safe nodes as well.
//
//So, the intuition is to figure out the nodes which are neither a part of a cycle
// nor connected to the cycle. We have previously solved this problem using the DFS
// traversal technique. Now, we are going to solve it using the BFS traversal technique
// especially using the topological sort algorithm. The topological sort algorithm will
// automatically exclude the nodes which are either forming a cycle or connected to
// a cycle. Note: Points to remember that any node which is a part of a cycle or leads
// to the cycle through an incoming edge towards the cycle, cannot be a safe node.
// Apart from these types of nodes, every node is a safe node.


//        The node with outdegree 0 is considered to be a terminal node
//        but the topological sort algorithm deals with the indegrees of
//        the nodes. So, to use the topological sort algorithm, we will
//        reverse every edge of the graph. Now, the nodes with indegree 0
//        become the terminal nodes. After this step, we will just follow
//        the topological sort algorithm as it is.


public class EventualSafeState {

    public static void state(int V, ArrayList<ArrayList<Integer>> adj){

        // first reverse the edges of the given graph
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }

        for(int i =0; i<adj.size(); i++){

            for(int a: adj.get(i)){
                revAdj.get(a).add(i);
            }
        }

        // calculate the initial indgree of  the revadj
        int[] inDegree = new int[V];
        for (ArrayList<Integer> integers : revAdj) {
            for (int a : integers) {
                inDegree[a]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i =0; i<V; i++){
            if(inDegree[i] ==0){
                q.add(i);
            }
        }

        //decrease the indgree of the element in the queue

        int[] topo = new int[V];
        int t =0;

        while(!q.isEmpty()){
            int node = q.poll();
            topo[t++] = node;

            for(int a: revAdj.get(node)){
                inDegree[a]--;
                if(inDegree[a]==0) q.add(a);
            }
        }

        for(int a: topo){
            System.out.println(a+ " ");
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int V = 12;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);
        state(V, adj);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
