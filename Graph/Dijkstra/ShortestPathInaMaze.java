package Graph.Dijkstra;

import java.util.LinkedList;
import java.util.Queue;

//Approach:
//        We’ll solve this problem by Dijkstra’s Algorithm using a simple queue.
//        Since, there is no adjacency list for this particular problem we can
//        say that the adjacent cell for a coordinate is that cell which is either
//        on the top, bottom, left, or right of the current cell i.e, a cell can
//        have a maximum of 4 cells adjacent to it.
//
//
//        Initial configuration:
//
//        Source Node and Destination Node: Before starting off with the Algorithm,
//        we need to define a source node and a destination node, between which we
//        need the shortest possible distance.

//        Queue: Define a Queue which would contain pairs of the type {dist, pair
//        of coordinates of cell }, where ‘dist’ indicates the currently updated
//        value of the shortest distance from the source to the cell.

//        Distance Matrix: Define a distance matrix that would contain the distance
//        from the source cell to that particular cell. If a cell is marked as
//        ‘infinity’ then it is treated as unreachable/unvisited.

//        The Algorithm consists of the following steps :
//
//        Start by creating a queue that stores the distance-node pairs in the form
//        {dist, coordinates of cell pair} and a dist matrix with each cell initialized
//        with a very large number ( to indicate that they’re unvisited initially) and
//        the source cell marked as ‘0’.

//        We push the source cell to the queue along with its distance which is also 0.

//        Pop the element at the front of the queue and look out for its adjacent nodes
//        (left, right, bottom, and top cell). Also, for each cell, check the validity
//        of the cell if it lies within the limits of the matrix or not.

//        If the current reachable distance to a cell from the source is better than
//        the previous distance indicated by the distance matrix, we update the distance
//        and push it into the queue along with cell coordinates.

//        A cell with a lower distance would be at the front of the queue as opposed to
//        a node with a higher distance. We repeat the above two steps until the queue
//        becomes empty or until we encounter the destination node.

//        Return the calculated distance and stop the algorithm from reaching the
//        destination node. If the queue becomes empty and we don’t encounter the
//        destination node, return ‘-1’ indicating there’s no path from source to destination.

class disp {
    int distance;
    int row;
    int column;
    public disp(int distance, int row, int column){
        this.distance = distance;
        this.row= row;
        this.column = column;
    }
}
public class ShortestPathInaMaze {

    public static int maze(int[][] grid, int[] des, int[] src){

        Queue<disp> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        int[][] distance = new int[n][m];

        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                distance[i][j] = (int)(1e9);
            }
        }
        distance[src[0]][src[1]] =0;
        q.add(new disp(0, src[0], src[1]));

        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};

        // Iterate through the maze by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while(!q.isEmpty()){
            int dist = q.peek().distance;
            int row = q.peek().row;
            int col = q.peek().column;
            q.remove();

            for(int i =0; i<4; i++){
                int nrow = row + delr[i];
                int ncol = col + delc[i];

// Checking the validity of the cell and updating if dist is shorter.
                if(nrow<n && nrow>=0
                && ncol<m && ncol>=0 && grid[nrow][ncol]==1
                        && dist + 1< distance[nrow][ncol]){
                    distance[nrow][ncol]= dist + 1;
// Return the distance until the point when
                    // we encounter the destination cell.
                    if(nrow== des[0 ]&& ncol==des[1]) return dist+1;
                    q.add(new disp(dist+1, nrow, ncol));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] source={0,1};
        int[] destination={2,2};

        int[][] grid={{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};

        System.out.println(maze(grid, destination, source));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
