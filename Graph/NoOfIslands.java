package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class NoOfIslands {
    private static void bfs(int rows, int columns, int[][] graph, boolean[][] visited){

        Queue<Pair> q = new LinkedList<Pair>();

        visited[rows][columns] = true;
        q.add(new Pair(rows,columns));

        int n = graph.length;
        int m = graph[0].length;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int neighRo = -1; neighRo<=1; neighRo++){
                for(int neighCol = -1; neighCol<=1; neighCol++){
                    int nrows = row + neighRo;
                    int ncols = col + neighCol;

                    if(nrows>=0 && nrows<n
                    && ncols>=0 && ncols<m
                    && graph[nrows][ncols]==1
                    && !visited[nrows][ncols]){
                        visited[nrows][ncols] =true;
                        q.add(new Pair(nrows, ncols));
                    }
                }
            }
        }

    }
    public static int island(int[][] graph){
        //creating a 2d replica of the graph
        int n = graph.length;
        int m = graph[0].length;
       boolean[][] visited = new boolean[graph.length][graph[0].length];
        int count = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!visited[i][j] && graph[i][j]==1){
                    count++;
                    bfs(i, j, graph,visited);
                }
            }
        }

        return count;
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
