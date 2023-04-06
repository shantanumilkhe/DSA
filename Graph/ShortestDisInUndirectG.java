package Graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Intuition:

//        For finding the shortest path in an undirected graph with unit weight,
//        the technique we use is the Breadth-First Search (BFS). Now, the question
//        arises why do we use the BFS technique in finding the shortest path here
//        when we could’ve easily used other standard graph shortest path algorithms
//        to implement the same? If we start traversal from the src node, we move to
//        other adjacent nodes, everyone is at a distance of 1, so everyone goes into
//        the queue, then subsequently we get the next set of nodes at 1 more distance,
//        making the distance to 2, and if you look at the queue closely, it will look
//        something like below. Queue here acts as a sorted Queue, hence we don’t need
//        any sorted ds which we generally require in the other graph algorithms.

public class ShortestDisInUndirectG {

    public static void distance(int n, int m, int[][] edge, int src){

        // convert the given edges into a adj list.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0; i<n; i++) adj.add(new ArrayList<>());

        for(int i =0; i<edge.length; i++){
            int main = edge[i][0];
            int node = edge[i][1];
            adj.get(main).add(node);
        }

        // create a queue and add the source and its distance

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int[] dist= new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;

        while (!q.isEmpty()){
            int node = q.peek();
            q.poll();

            for(int it: adj.get(node) ){
                if(dist[node] + 1 < dist[it]) {
                    dist[it] = 1 + dist[node];
                    q.add(it);
                }
            }
        }

        for(int i = 0;i<n;i++) {
            if(dist[i]  >100000) {
                dist[i] = -1;
            }
        }

        for(int i = 0;i<n;i++) {
           System.out.println(dist[i]+ " ");
        }



    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};

        distance(n, m, edge, 0);


        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
