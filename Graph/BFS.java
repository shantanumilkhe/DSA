package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//note

// the variable "node" is declared as an object of the Integer class,
// and its value is set to the result of calling the "poll" method on
// the queue "q". The "Integer" class is a wrapper class for the
// primitive data type "int", and it provides additional functionality
// such as methods for converting to and from other data types.

// Time Complexity: O(N) + O(2E), Where N = Nodes,
// 2E is for total degrees as we traverse all adjacent nodes.
//
// Space Complexity: O(3N) ~ O(N), Space for queue data structure
// visited array and an adjacency list

public class BFS {
    public static ArrayList<Integer> BFS(int V, ArrayList<ArrayList<Integer>> Graph){

        ArrayList<Integer> bfs = new ArrayList<>(); // this will store the bfs result
        boolean visited[] = new boolean[V];        // this store the visited nodes
        Queue<Integer> q = new LinkedList<>();    // this will be the queue where we would put nodes, and work

        q.add(0);               // we are adding root node here to the queue
        visited[0] = true;     // also marking it visited

        while(!q.isEmpty()){
            Integer node = q.poll(); // read the note above first, also, we are taking out the first element
                                    // of the queue and storing it in the node integer
            bfs.add(node);         // here, we are adding the polled element in the bfs list

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it

            for(int i: Graph.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 5;
        for(int i=0; i<n; i++){
            ArrayList<Integer> row = new ArrayList<>();
            adj.add(row);
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        BFS b1 = new BFS();
        ArrayList<Integer> ans = b1.BFS(n, adj);

        for(int i = 0 ; i< ans.size(); i++){
            System.out.print(ans.get(i)+ " ");
        }



        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
