package Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//note: this algo does not work for negative weights.

//Approach:
//
//        We’ll be using Priority Queue in this approach for finding the shortest distances
//        from the source node to every other node through Dijkstra’s Algorithm.
//
//        Initial configuration:
//
//        Source Node: Before starting off with the Algorithm, we need to define a source node
//        from which the shortest distances to every other node would be calculated.

//        Priority Queue: Define a Priority Queue which would contain pairs of the type {dist, node},
//        where ‘dist’ indicates the currently updated value of the shortest distance from the
//        source to the ‘node’.

//        Dist Array: Define a dist array initialized with a large integer number at the start
//        indicating that the nodes are unvisited initially. This array stores the shortest
//        distances to all the nodes from the source node.
//
//        The Algorithm consists of the following steps :
//
//        We would be using a min-heap and a distance array of size V (where ‘V’ are the
//        number of nodes in the graph) initialized with infinity (indicating that at present
//        none of the nodes are reachable from the source node) and initialize the distance
//        to source node as 0.

//        We push the source node to the queue along with its distance which is also 0.

//        For every node at the top of the queue, we pop the element out and look out for
//        its adjacent nodes. If the current reachable distance is better than the previous
//        distance indicated by the distance array, we update the distance and push it into
//        the queue.

//The Intuition behind using Priority Queue and not just Queue in Dijkstra’s Algorithm :

// Although we can get a solution by just using the Queue data structure also, using a
// Priority Queue provides us an edge over the method in which only Queue is used. Now,
// you may wonder why is that so.
// Priority Queue implements Min Heap which eventually gives us the minimum element at
// the top of the priority queue thus reducing the number of traversals to be done in a
// graph in case a normal queue is being used. The only difference between a queue and
// a priority queue is that we have to traverse all connected nodes of a current node
// and find the minimum among them when we use a normal queue which takes time of O(V).
// But using the priority queue we can optimize it to O(log V) by reducing the unnecessary
// exploration of paths.

//Time Complexity: O( E log(V) ), Where E = Number of edges and V = Number of Nodes.
//
//Space Complexity: O( |E| + |V| ), Where E = Number of edges and V = Number of Nodes.

class Pair{
    int distance;
    int node;
    public Pair(int distance,int node){
        this.distance = distance;
        this.node = node;
    }
}
public class DijkstraPQ {

    public static void dijkstra(int V,  int s, ArrayList<ArrayList<ArrayList<Integer>>>adj){

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
                    pq.add(new Pair(distance[edgeNode], edgeNode));
                }

            }
        }

        for(int a: distance){
            System.out.println(a+ " ");
        }


    }


    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // here we are delcaring a three tier arraylist
        // normally each row of arraylist contains a Integer, but we need to store the wt of that edge
        // so each node that is connected to u will have its corresponding wt. so we will store that in
        // a another arraylist

        int V = 3, E=3,S=2; // s is the src.

        // here we are declaring the nodes 1st number is the node itself and next is the wt associated with it
        ArrayList<Integer> node1 = new ArrayList<Integer>() {
            {
                add(1);
                add(1);
            }
        };
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};

        // then these nodes are added to the row
        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }
        };
        // finally the rows are added to the list itself
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };

        dijkstra(V, S, adj);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
