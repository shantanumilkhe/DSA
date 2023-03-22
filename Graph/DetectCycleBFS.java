package Graph;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class QueueElement{

    int current;
    int parent;

    public QueueElement(int current, int parent){
        this.current = current;
        this.parent = parent;
    }
}
public class DetectCycleBFS {

    public static boolean detect(int sr, ArrayList<ArrayList<Integer>> Graph, boolean[] visited){

        Queue<QueueElement> q = new LinkedList<>();
        q.add(new QueueElement(sr, -1)); //set the first element of the q as the sr and its parent as -1
        visited[sr] = true;

        while(!q.isEmpty()){
            int srNew = q.peek().current;
            int parent = q.peek().parent;
            q.remove();
            // traverse to every edge of the current element using this for loop
            for(int i: Graph.get(srNew)){
                // if the adjacent node is not visited, add it to the queue
                if(!visited[i]){
                    q.add(new QueueElement(i, srNew));
                    visited[i] = true;
                }
                // but if it is visited that can mean only two things,
                // 1. that visited vertex is the parent or
                // 2. that element was previously visited by someone else
                //    that indicates there is cycle as paths are crossed.
                else if(parent != i ) return true;
            }
        }

        return false;
    }

    private static boolean cycle( ArrayList<ArrayList<Integer>> Graph, int V){

        // create a boolean visited and set it to false
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // the graph might be disconnected so, to check for cycle in each
        // component we use this for loop
        for(int i=0; i<V; i++){
            //if the vertex is not visited earlier, we will keep that vertex as a source
            // and use the function detect, if it returns true, then return true else return false.
            if(!visited[i]){
                if(detect(i, Graph, visited)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
//       adj.get(0).add(1);
//       adj.get(1).add(0);
//       adj.get(1).add(2);
//       adj.get(1).add(4);
//       adj.get(2).add(1);
//       adj.get(2).add(3);
//       adj.get(3).add(2);
//       adj.get(3).add(4);
//       adj.get(4).add(1);
//       adj.get(4).add(3);

        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);


      System.out.println(cycle(adj, 4));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
