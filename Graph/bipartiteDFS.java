package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class bipartiteDFS {

    public static boolean dfs(int i, int color, int[] colored, ArrayList<ArrayList<Integer>> adj){

        colored[i]=color;
       for(int a: adj.get(i)){
           if(colored[a]==-1){
               if(!dfs(a, 1 - color, colored, adj)) return false;
           }
           else if(colored[a]==color) return false;
       }
        return true;
    }

    public static boolean bipart(int V, ArrayList<ArrayList<Integer>> adj){

        int[] colored = new int[V];
        Arrays.fill(colored, -1);


        for(int i =0; i<V; i++){
            if (colored[i]==-1)
                if(!dfs(i, 0, colored, adj)) return false;
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
