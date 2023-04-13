package Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class shortestPath {
    public static void shortest(int V,  int s, ArrayList<ArrayList<ArrayList<Integer>>>adj, int des){

        // Create a priority queue for storing the nodes as a pair {dist, node
        // where dist is the distance from source to the node.
        PriorityQueue<Pair> pq =
                new PriorityQueue<Pair>((x,y)-> x.distance - y.distance);

        // create the distance array and set all values to some big value
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e9);

        // distance of source node from itself is always zero
        distance[s] = 0;
        pq.add(new Pair(0, s));

        int[] parent = new int[V];
        parent[s]=s;

        // now traverse the queue

        while(!pq.isEmpty()){
            int dist = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            // Check for all adjacent nodes of the popped out
            // element whether the prev dist is larger than current or not.
            for(int i =0; i<adj.get(node).size(); i++){
                int edgWT = adj.get(node).get(i).get(1);
                int edgeNode = adj.get(node).get(i).get(0);

                // If current distance is smaller,
                // push it into the queue.
                if(dist+edgWT<distance[edgeNode]){
                    distance[edgeNode]= dist+ edgWT;
                    parent[edgeNode] = node;
                    pq.add(new Pair(distance[edgeNode], edgeNode));
                }

            }
        }
        int cur = des;
       do{
          int a = parent[cur];
          System.out.println(a);
          cur = a;
       }while(cur==s);


    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int V = 5, E = 6;

        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};



        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
