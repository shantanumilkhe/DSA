package Graph.Dijkstra;

import java.util.PriorityQueue;


//In this problem, we need to minimize the effort of moving from the source cell (0,0) to
// the destination cell (n – 1,m – 1). The effort can be calculated as the maximum value of
// the difference between the node and its next node in the path from the source to the
// destination. Among all the possible paths, we have to minimize this effort. So, for these
// types of minimum path problems, there’s one standard algorithm that always comes to our
// mind and that is Dijkstra’s Algorithm which would be used in solving this problem also. We
// update the distance every time we encounter a value of difference less than the previous value.
// This way, whenever we reach the destination we finally return the value of difference which is
// also the minimum effort.

class Path{
    int diff, row, column;
    public Path(int diff, int row, int column){
        this.diff = diff;
        this.row = row;
        this.column = column;
    }
}
public class PathWithMinEffort {
    public static int path(int[][] grid){
        int n= grid.length;
        int m = grid[0].length;


        // Create a distance matrix with initially all the cells marked as
        // unvisited and the dist for source cell (0,0) as 0.
        int[][] dist = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                dist[i][j] = (int)(1e9);
            }
        }

        // create a pq
        PriorityQueue<Path> pq = new PriorityQueue<>((x,y) -> x.diff-y.diff);
        pq.add(new Path(0, 0,0));
        dist[0][0]=0;

        // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have
        // in a direction.
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};


        while(!pq.isEmpty()){
            int diff = pq.peek().diff;
            int row = pq.peek().row;
            int col = pq.peek().column;
            pq.remove();

            // Check if we have reached the destination cell,
            // return the current value of difference (which will be min).
            if(row == n-1 && col==m-1) return diff;

            for(int i =0; i<4; i++) {
                int nr = row+delr[i];
                int nc = col+delc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m){

                    // calculate the max effort mate
                    int newEffort = Math.max(Math.abs(grid[nr][nc]-grid[row][col]), diff);

                    if(newEffort< dist[nr][nc]){
                        dist[nr][nc]=newEffort;
                        pq.add(new Path(newEffort, nr, nc));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        System.out.println(path(heights));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
