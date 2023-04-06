package Graph.Topological;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//Intuition:
//
//        Finding the shortest path to a vertex is easy
//        if you already know the shortest paths to all the vertices that can precede it.
//        Processing the vertices in topological order ensures that by the time you get to
//        a vertex, you’ve already processed all the vertices that can precede it which
//        reduces the computation time significantly. In this approach, we traverse the nodes
//        sequentially according to their reachability from the source.
//
//        Dijkstra’s algorithm is necessary for graphs that can contain cycles because they
//        can’t be topologically sorted. In other cases, the topological sort would work
//        fine as we start from the first node, and then move on to the others in a directed manner.

//        Approach:
//
//        We will calculate the shortest path in a directed acyclic graph by using topological sort.
//        Topological sort can be implemented in two ways- BFS and DFS. Here, we will be implementing
//        using the DFS technique. Depth First Search, DFS is a traversal technique where we visit a
//        node and then continue visiting its adjacent nodes until we reach the end point, i.e., it
//        keeps on moving in the depth of a particular node and then backtracks when no further adjacent
//        nodes are available.

//        Initial configuration:
//
//        Adjacency List: Create an adjacency list of the formed vector of pairs of size ‘N’,
//        where each index denotes a node ‘u’ and contains a vector that consists of pairs denoting
//        the adjacent nodes ‘v’ and the distance to that adjacent node from initial node ‘u’.

//        Visited Array: Create a visited array and mark all the indices as unvisited (0) initially.

//        Stack: Define a stack data structure to store the topological sort.

//        Distance Array: Initialise this array by Max integer value and then update the value for
//        each node successively while calculating the shortest distance between the source and the current node.
//

//        The shortest path in a directed acyclic graph can be calculated by the following steps:
//
//        Perform topological sort on the graph using BFS/DFS and store it in a stack.
//        In order to get a hang of how the Topological Sort works, you can refer to this article for the same.

//        Now, iterate on the topo sort. We can keep the generated topo sort in the stack only, and do
//        an iteration on it, it reduces the extra space which would have been required to store it.
//        Make sure for the source node, we will assign dist[src] = 0.

//        For every node that comes out of the stack which contains our topo sort, we can traverse
//        for all its adjacent nodes, and relax them.

//        In order to relax them, we simply do a simple comparison of dist[node] + wt and dist[adjNode].
//        Here dist[node] means the distance taken to reach the current node, and it is the edge weight
//        between the node and the adjNode.

//        If (dist[node] + wt < dist[adjNode]), then we will go ahead and update the distance of the
//        dist[adjNode] to the new found better path.

//        Once all the nodes have been iterated, the dist[] array will store the shortest paths and
//        we can then return it.

class Pair{

    int node;
    int weight;
    public Pair(int node, int weight){
        this.weight = weight;
        this.node = node;
    }
}
public class shortestPath {

    public static void topoDFS(boolean[] visited, ArrayList<ArrayList<Pair>> adj,
    Stack<Integer> st,  int node){
        visited[node]=true;

        for(int i =0; i<adj.get(node).size(); i++){
            int neigh = adj.get(node).get(i).node;
            if(!visited[neigh]){
                topoDFS(visited, adj, st, neigh);
            }
        }
        st.push(node);
    }

    public static void shortest(int V, int[][] edge){
        // convert the given edges into a adj list.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i =0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<edge.length; i++){
            int main = edge[i][0];
            int node = edge[i][1];
            int wt = edge[i][2];
            adj.get(main).add(new Pair(node, wt));
        }

        //now call the topo sort method to get the stack of the sorted nodes
        // i will be using DFS method as we use stack in it.
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        for(int i =0; i<V; i++){
            if(!visited[i]){
                topoDFS(visited, adj, st, i);
            }
        }

        // after the topo sort is done, we will find the distance

        int[] distance = new int[V];    // we will create a distance array and
        Arrays.fill(distance, Integer.MAX_VALUE); // initially set all the values to infinity.

        distance[0]= 0;

        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();

            for(int i =0; i<adj.get(node).size(); i++){
                int neigh = adj.get(node).get(i).node;
                int wt = adj.get(node).get(i).weight;

                if(distance[node]+wt<distance[neigh]){
                    distance[neigh] = distance[node]+wt;
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }




    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

        shortest(6, edge);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
