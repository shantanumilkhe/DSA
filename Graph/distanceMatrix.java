package Graph;

import java.util.LinkedList;
import java.util.Queue;

//Intuition:
//
//        Breadth First Search, BFS, is a traversal technique where we
//        visit the nodes level-wise, i.e., it visits the same level nodes
//        simultaneously, and then moves to the next level.
//
//        The intuition is that BFS will take a step from cells containing 1
//        and will reach out to all zeros that are at a distance of one.
//        Apparently, we can say that the nearest 1 to the 0s is at a distance
//        of one. Again if we take another step, we will reach the next set of
//        zeros, for these zeros 1 is at a distance of two. If we continue the
//        same, till we can go, we can reach all the 0’s possible.
//
//        We will choose the BFS algorithm as it moves step by step and we
//        want all of them to traverse in a single step together so that we can
//        have a minimum count with us.

//The algorithm steps are as follows:
//
//        Push the pair of starting points and its steps (<coordinates, stept>)
//        in the queue, and mark the cell as visited.

//        Start the BFS traversal, pop out an element from the queue every time,
//        and travel to all its unvisited neighbors having 0.

//        For every neighboring unvisited 0, we can mark the distance to be +1 of the
//        current node distance and store it in the distance 2D array, and at the same
//        time insert <{row, col}, steps+1> into the queue.

//        Repeat the steps until the queue becomes empty and then return the distance
//        matrix where we have stored the steps.


// Time Complexity: O(NxM + NxMx4) ~ O(N x M)
//
//   For the worst case, the BFS function will be called for (N x M) nodes,
//   and for every node, we are traversing for 4 neighbors, so it will take
//    O(N x M x 4) time.
//
// Space Complexity: O(N x M) + O(N x M) + O(N x M) ~ O(N x M)
//
// O(N x M) for the visited array, distance matrix, and queue
// space takes up N x M locations at max.

class coordinate{
    int row;
    int column;
    int step;
    public coordinate(int row, int column, int step){
        this.row = row;
        this.column= column;
        this.step = step;
    }
}
public class distanceMatrix {

    public static int[][] distance(int[][] grid, int[] delr, int[] delc){
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] visited =  new boolean[n][m];
        for(boolean[] row: visited){
            for (boolean a: row){
                a = false;
            }
        }

        int[][] distance = new int[n][m];
        Queue<coordinate> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1){
                    q.add(new coordinate(i, j, 0));
                    visited[i][j]=true;
                    distance[i][j]=0;
                }
            }
        }

        while(!q.isEmpty()){

            int row = q.peek().row;
            int col = q.peek().column;
            int step = q.peek().step;
            q.remove();
            distance[row][col] = step;
            for(int i=0; i<4; i++){
                int neighrow = row + delr[i];
                int neighcol = col + delc[i];

                if(neighrow<n && neighrow>=0
                && neighcol<n && neighcol>=0
                && !visited[neighrow][neighcol]){
                    q.add(new coordinate(neighrow, neighcol, step+1));
                    visited[neighrow][neighcol]=true;
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, +1, 0, -1};

        int[][] ans = distance(grid, deltaRow, deltaCol);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
