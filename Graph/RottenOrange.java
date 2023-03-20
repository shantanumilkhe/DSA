package Graph;
import java.util.LinkedList;
import java.util.Queue;

//Problem Statement: Given a grid of dimension N x M where each cell in the grid can have values
// 0, 1, or 2 which has the following meaning:
//
//        0: Empty cell
//        1: Cells have fresh oranges
//        2: Cells have rotten oranges
//
//        We have to determine what is the minimum time required to rot all oranges.
//        A rotten orange at index [i,j] can rot other fresh oranges at indexes
//        [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.
//
//        Pre-req: Graph traversal techniques, Queue STL

//The algorithm steps are as follows:
//
//        For BFS traversal, we need a queue data structure and a visited array. Create a
//        replica of the given array, i.e., create another array of the same size and call
//        it a visited array. We can use the same matrix, but we will avoid alteration of the original data.

//        The pairs of cell number and initial time, i.e., <<row, column>, time> will be pushed
//        in the queue and marked as visited (represents rotten) in the visited array. For example,
//        ((2,0), 0) represents cell (2, 0) and initial time 0.

//        While BFS traversal, pop out an element from the queue and travel to all its neighbours.
//        In a graph, we store the list of neighbours in an adjacency list but here we know the
//        neighbours are in 4 directions.

//        We go in all 4 directions and check for valid unvisited fresh orange neighbours.
//        To travel 4 directions we will use nested loops, you can find the implementation
//        details in the code.

//        BFS function call will make sure that it starts the BFS call from each rotten
//        orange cell, and rotten all the valid fresh orange neighbours and puts them in
//        the queue with an increase in time by 1 unit. Make sure to mark it as rotten in
//        the visited array.

//        Pop-out another rotten orange from the queue and repeat the same steps until the
//        queue becomes empty.

//        Add a counter variable to store the maximum time and return it. If any of the fresh
//        was not rotten in the visited array then return -1.

// Time Complexity: O(NxM + NxMx4) ~ O(N x M), For the worst case, all of the cells will have
// fresh oranges, so the BFS function will be called for (N x M) nodes and for every node, we
// are traversing for 4 neighbours, it will take O(N x M x 4) time.
//
// Space Complexity ~ O(N x M), O(N x M) for copied input array and recursive
// stack space takes up N x M locations at max.

class OrangePair{
    int first;
    int second;
    int time;
    public OrangePair(int first, int second, int time){
        this.first = first;
        this.second = second;
        this.time = time;
    }
}
public class RottenOrange {

    public static int oranges(int[][] Oranges, int[] delr, int[] delc){

        Queue<OrangePair> q = new LinkedList<OrangePair>(); // create a new q with a OrangePair as its DS.
        int n = Oranges.length;
        int m = Oranges[0].length;
        int[][] visited = new int[n][m];
        int countFresh = 0; // this counter will be used to check if any of the fresh orange was left to
                            // rot.

        // this for loops is used to determine the location of rotted oranges and the count of the fresh oranges.
        // we also mark the visited the array.
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(Oranges[i][j]==2){
                    q.add(new OrangePair(i,j,0));
                    visited[i][j] = 2;
                }
                if(Oranges[i][j]==1) countFresh++;
                if(Oranges[i][j]==0) visited[i][j]=0;
            }
        }

        // this is the BFS traversal. we keep a time counter outside.
        int time = 0;
        int count = 0;
        while(!q.isEmpty()){
            // get the OrangePair data and then remove the element.
            int row = q.peek().first;
            int col = q.peek().second;
            int t = q.peek().time;
            time = Math.max(time, t);
            q.remove();

            // this is a smart way of visiting various neighbours.
            // here we use a for loop to visit every neighbour of our polled element.
            for(int i = 0; i<4; i++){
                int neighRow = row+ delr[i];
                int neighCol = col+ delc[i];

                // if the cell has a fresh orange and is not visited, add it to the queue and update
                // the fresh counter.
                if(neighRow>=0 && neighRow<n
                && neighCol>=0 && neighCol<m
                && Oranges[neighRow][neighCol]==1
                && visited[neighRow][neighCol] !=2){
                    visited[neighRow][neighCol]=2;
                    q.add(new OrangePair(neighRow, neighCol, time+1));
                    count++;
                }
            }
        }

        if(count!=countFresh) return -1;
        return time;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[][] Oranges =  {
                {0,1,2},
                {0,1,1},
                {2,1,1}
        };

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, +1, 0, -1};


        System.out.println(oranges(Oranges,deltaRow, deltaCol));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
