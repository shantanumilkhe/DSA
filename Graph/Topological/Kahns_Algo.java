package Graph.Topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Kahns_Algo {

    public static void kahn(int V,  ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[V];

        for (ArrayList<Integer> integers : adj) {
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

        int[] sort = new int[V];
        int k =0;

        while(!q.isEmpty()){
            int node = q.poll();
            sort[k++]= node;

            for(int a : adj.get(node)){
                inDegree[a]--;
                if(inDegree[a]==0) q.add(a);
            }
        }

        for(int a: sort){
            System.out.println(a+ " ");
        }
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        kahn(V, adj);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
