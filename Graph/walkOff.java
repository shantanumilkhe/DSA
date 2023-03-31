package Graph;
import java.util.LinkedList;
import java.util.Queue;

//Problem Statement:
// You are given an N x M binary matrix grid, where 0 represents a sea cell and 1
// represents a land cell. A move consists of walking from one land cell to another
// adjacent (4-directionally) land cell or walking off the boundary of the grid.
// Find the number of land cells in the grid for which we cannot walk off the boundary
// of the grid in any number of moves.

//Approach:
//
//        We can follow either of the traversal techniques as long as we
//        are starting with a boundary element and marking all those 1s
//        connected to it. We will be solving it using BFS traversal, but
//        you can apply DFS traversal as well, we have applied DFS traversal
//        to solve a similar problem in the previous article.
//
//        Breadth First Search, BFS is a traversal technique where we visit
//        the nodes level-wise, i.e., it visits the same level nodes simultaneously,
//        and then moves to the next level.


//Time Complexity: O(NxMx4) ~ O(N x M), For the worst case, assuming all the pieces as
// land, the BFS function will be called for (N x M) nodes and for every node, we are
// traversing for 4 neighbors, so it will take O(N x M x 4) time.
//
//Space Complexity ~ O(N x M), O(N x M) for the visited array, and queue space
// takes up N x M locations at max.

public class walkOff {

    public static int bound(int[][] grid){

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();

        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                // first row, first col, last row, last col
                if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                    if(grid[i][j]==1){
                        q.add(new Pair(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }

        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int i=0; i<4; i++){
                int nrow = row+delr[i];
                int ncol = col+delc[i];

                if(nrow<n && nrow>=0
                && ncol<m && ncol>=0
                && !visited[nrow][ncol]
                && grid[nrow][ncol]==1){
                    visited[nrow][ncol] =true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        int cnt =0;
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                // first row, first col, last row, last col
                if(grid[i][j]==1 && !visited[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;

    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int grid[][] = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};

        System.out.println(bound(grid));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
