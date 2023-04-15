package Graph.Dijkstra;

import jdk.jfr.FlightRecorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//Intuition:
//
//        Since in this problem, we have to calculate the minimum cost to reach the destination
//        from the source but with a restriction on the number of stops, we would be using
//        Dijkstra’s Algorithm. Now, one must wonder that based on what parameter we should
//        add elements to the priority queue.
//
//        Now, if we store the elements in the priority queue with the priority given to the
//        minimum distance first, then after a few iterations we would realize that the Algorithm
//        will halt when the number of stops would exceed. This may result in a wrong answer as
//        it would not allow us to explore those paths which have more cost but fewer stops than
//        the current answer.
//
//        To tackle this issue, we store the elements in terms of the minimum number of stops
//        in the priority queue so that when the algorithm halts, we can get the minimum cost within limits.
//
//        Also, a point to note here is that do we really need a priority queue for carrying out
//        the algorithm? The answer for that is No because when we are storing everything in terms
//        of a number of stops, the stops are increasing monotonically which means that the number
//        of sops is increasing by 1 and when we pop an element out of the queue, we are always
//        popping the element with a lesser number of stops first. Replacing the priority queue
//        with a simple queue will let us eliminate an extra log(N) of the complexity of insertion-deletion
//        in a priority queue which would in turn make our algorithm a lot faster.
//
//        Approach:
//
//        Initial configuration:
//
//        Queue: Define a Queue that would contain pairs of the type {stops, {node,dist} },
//        where ‘dist’ indicates the currently updated value of the distance from the source
//        to the ‘node’ and ‘stops’ contains the number of nodes one has to traverse in order
//        to reach node from src.

//        Distance Array: Define a distance array that would contain the minimum cost/distance
//        from the source cell to a particular cell. If a cell is marked as ‘infinity’ then it is
//        treated as unreachable/unvisited.

//        Source and Destination: Define the source and the destination from where the flights have to run.
//
//        The Algorithm consists of the following steps :
//
//        Start by creating an adjacency list, a queue that stores the distance-node and stops
//        pairs in the form {stops,{node,dist}} and a dist array with each node initialized with
//        a very large number ( to indicate that they’re unvisited initially) and the source node
//        marked as ‘0’.

//        We push the source cell to the queue along with its distance which is also 0 and the
//        stops are marked as ‘0’ initially because we’ve just started.

//        Pop the element at the front of the queue and look out for its adjacent nodes.

//        If the current dist value of a node is better than the previous distance indicated by
//        the distance array and the number of stops until now is less than K, we update the distance
//        in the array and push it to the queue. Also, increase the stop count by 1.

//        We repeat the above three steps until the queue becomes empty. Note that we do not stop
//        the algorithm from just reaching the destination node as it may give incorrect results.

//        Return the calculated distance/cost after we reach the required number of stops. If the
//        queue becomes empty and we don’t encounter the destination node, return ‘-1’ indicating
//        there’s no path from source to destination.

class node{
    int node, cost;
    public node(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}

class flight{
    int stops, node, cost;
    public flight(int stops, int node,int cost){
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}
public class KStops {

    public static int stops(int V, int[][] edges, int src, int dst, int k){

        ArrayList<ArrayList<node>> adj = new ArrayList<>();

        for(int i=0; i<V; i++) adj.add(new ArrayList<>());

        for(int i =0; i<edges.length; i++){
            adj.get(edges[i][0]).add(new node(edges[i][1], edges[i][2]));
        }

        // Distance array to store the updated distances from the source.
        int[] dist = new int[V];
        for(int i = 0;i<V;i++) {
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;

        // here pq is not need as number of stops increases in units.
        // Create a queue which stores the node and their distances from the
        // source in the form of {stops, {node, dist}} with ‘stops’ indicating
        // the no. of nodes between src and current node.
        Queue<flight> q = new LinkedList<>();

        q.add(new flight(0, src, 0));

        // Iterate through the graph using a queue like in Dijkstra with
        // popping out the element with min stops first.
        while(!q.isEmpty()){
            int stops = q.peek().stops;
            int node = q.peek().node;
            int cost = q.peek().cost;
            q.poll();

            // We stop the process as soon as the limit for the stops reaches.
            if(stops>k) continue;
            for(node v: adj.get(node)){
                int nodeV = v.node;
                int wt = v.cost;


                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if(cost+wt< dist[nodeV] && stops<=k){
                    q.add(new flight(stops+1, nodeV, cost+wt));
                    dist[nodeV]= cost+wt;
                }
            }
        }
// If the destination node is unreachable return ‘-1’
        // else return the calculated dist from src to dst.
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];

    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        System.out.println(stops(n, flights, src, dst, K));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
