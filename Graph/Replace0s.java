package Graph;

//Approach:
//
//        We can follow either of the traversal techniques as long as we are
//        starting with a boundary element and marking all those Os connected
//        to it. We will be solving it using DFS traversal, but you can apply
//        BFS traversal as well.
//
//        DFS is a traversal technique that involves the idea of recursion..
//        DFS goes in-depth, i.e., traverses all nodes by going ahead, and
//        when there are no further nodes to traverse in the current path,
//        then it backtracks on the same path and traverses other unvisited nodes.
//
//        The algorithm steps are as follows:
//
//        Create a corresponding visited matrix and initialize it to 0.

//        Start with boundary elements, once ‘O’ is found, call the DFS
//        function for that element and mark it as visited. In order to
//        traverse for boundary elements, you can traverse through the
//        first row, last row, first column, and last column.

//        DFS function call will run through all the unvisited neighboring
//        ‘O’s in all 4 directions and mark them as visited so that they
//        are not converted to ‘X’ in the future. The DFS function will
//        not be called for the already visited elements to save time, as
//        they have already been traversed.

//        When all the boundaries are traversed and corresponding sets of
//        ‘O’s are marked as visited, they cannot be replaced with ‘X’. All
//        the other remaining unvisited ‘O’s are replaced with ‘X’. This can
//        be done in the same input matrix as the problem talks about replacing
//        the values, otherwise tampering with data is not advised.


//Time Complexity: O(N) + O(M) + O(NxMx4) ~ O(N x M),
// For the worst case, every element will be marked as
// ‘O’ in the matrix, and the DFS function will be called
// for (N x M) nodes and for every node, we are traversing
// for 4 neighbors, so it will take O(N x M x 4) time. Also,
// we are running loops for boundary elements so it will take
// O(N) + O(M).
//
//Space Complexity ~ O(N x M), O(N x M) for the visited array, and
// auxiliary stack space takes up N x M locations at max.
public class Replace0s {

    public static void dfs(char[][]grid, boolean[][] visited, int n, int m, int i, int j){
        visited[i][j] = true;
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};

        for(int k =0; k<4; k++){
            int neighr = i + delr[k];
            int neighc = j + delc[k];

            if(neighr<n && neighr>=0
                    &&neighc<m && neighc>=0
                    && !visited[neighr][neighc]
                    && grid[neighr][neighc]=='O'){
                dfs(grid, visited, n ,m , neighr, neighc);
            }
        }
    }

    public static char[][] boundry(char[][] grid, int n, int m){
        char[][] ans = grid;
        boolean[][] visited = new boolean[n][m];


            for(int j = 0; j<m; j++){
               if(!visited[0][j] && grid[0][j]=='O'){
                   dfs(grid, visited, n ,m , 0, j);
               }
                if(!visited[n-1][j] && grid[n-1][j]=='O'){
                    dfs(grid, visited, n ,m , n-1, j);
                }
            }


            for(int i = 0; i<n; i++){
                if(!visited[i][0] && grid[i][0]=='O'){
                    dfs(grid, visited, n ,m , i, 0);
                }
                if(!visited[i][m-1] && grid[i][m-1]=='O'){
                    dfs(grid, visited, n ,m , i, m-1);
                }
            }

            for(int i =0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(grid[i][j]=='O' && !visited[i][j]){
                        ans[i][j] ='X';
                    }
                }
            }


        return ans;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};

        // n = 5, m = 4

        char[][] ans = boundry(mat, 5, 4);
        for(int i = 0;i < 5;i++) {
            for(int j = 0;j < 4;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }



        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
