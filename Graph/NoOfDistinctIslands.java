package Graph;

import java.util.*;


public class NoOfDistinctIslands {
    private static void dfs(int rows, int columns, int[][] graph, boolean[][] visited, ArrayList<String> list,
                            int row0, int col0){
        visited[rows][columns] = true;
        list.add(toString(rows-row0,columns-col0));
        int n = graph.length;
        int m = graph[0].length;

        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};

        for(int i =0; i<4; i++){
            int nrow = rows+ delr[i];
            int ncol = columns + delc[i];

            if(nrow<n && nrow>=0
            && ncol>=0 && ncol<m
            && !visited[nrow][ncol]
            && graph[nrow][ncol]==1){
                dfs(nrow, ncol, graph, visited, list, row0, col0);
            }
        }



    }

    private static String toString(int i, int i1) {
        return Integer.toString(i) + " " + Integer.toString(i1);
    }

    public static int island(int[][] graph){
        //creating a 2d replica of the graph
        int n = graph.length;
        int m = graph[0].length;
       boolean[][] visited = new boolean[graph.length][graph[0].length];
        int count = 0;

        HashSet<ArrayList<String>> set = new HashSet<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!visited[i][j] && graph[i][j]==1){
                    ArrayList<String> list = new ArrayList<>();
                   dfs(i, j, graph,visited,list, i, j);
                   set.add(list);
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[][] island = new int[][]{
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };
        System.out.println(island(island));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
