package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Approach:
//
//        We can follow either of the traversal techniques.
//        we will be solving it using BFS traversal.
//
//        Breadth First Search, BFS is a traversal technique where we
//        visit the nodes level-wise, i.e., it visits the same level
//        nodes simultaneously, and then moves to the next level. We
//        will be defining the BFS traversal below, but this check has
//        to be done for every component, for that we can use the simple
//        for loop concept that we have learnt, to call the traversals for unvisited nodes.
//
//        Initial configuration:
//
//        Queue: Define a queue and insert the source node initially to start with.
//        Colour array: Instead of a visited array, we will take a colour array
//        where all the nodes are initialised to -1 indicating they are not coloured yet.
//
//        The algorithm steps are as follows:
//
//        For BFS traversal, we need a queue data structure and a visited
//        array (in this case colour array).

//        Take the source node and push it into the Queue. Whenever we try
//        to put it in the queue, we assign a colour to the node. We will try
//        to colour with 0 and 1, but you can choose other colours as well.
//        We will start with the colour 0, you can start with 1 as well,
//        just make sure for the adjacent node, it should be opposite of
//        what the current node has.

//        Start the BFS traversal, pop out an element from the queue every time
//        and travel to all its uncoloured neighbours using the adjacency list.

//        For every uncoloured node, initialise it with the opposite colour to
//        that of the current node, and push it into the Q data structure, for further traversals.

//        Repeat the steps either until the queue becomes empty.

//        If at any moment, we get an adjacent node from the adjacency list
//        which is already coloured and has the same colour as the current node,
//        we can say it is not possible to colour it, hence it cannot be bipartite.
//        Thereby we will stop the check here, and return a false, without visiting
//        any further nodes.

//        If the queue becomes empty, the graph is coloured and no two adjacent nodes
//        have the same colour then return value 1 indicating it is a bipartite graph.


//Time Complexity: O(V + 2E), Where V = Vertices, 2E is for total degrees as we
// traverse all adjacent nodes.
//
//Space Complexity: O(3V) ~ O(V), Space for queue data structure, colour array
// and an adjacency list.

public class bipartite {

    public static boolean bfs(int initial, int V, ArrayList<ArrayList<Integer>> adj, int[] colored){

        Queue<Integer> q = new LinkedList<>();
        q.add(initial);
        colored[initial]=0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int a: adj.get(node)){
                if(colored[a]==-1){
                    if(colored[node]==0) colored[a] =1;
                    if(colored[node]==1) colored[a] =0;
                    q.add(a);
                }
                else if(colored[a]==colored[node]) return false;
            }
        }
        return true;
    }

    public static boolean bipart(int V, ArrayList<ArrayList<Integer>> adj){

        int[] colored = new int[V];
        Arrays.fill(colored, -1);


        for(int i =0; i<V; i++){
            if (colored[i]==-1)
                if(!bfs(i, V, adj, colored)) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        ArrayList <ArrayList< Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.println(bipart(4, adj));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
