package Graph;

//Problem Statement: An image is represented by a 2-D array of integers, each
// integer representing the pixel value of the image. Given a coordinate (sr, sc)
// representing the starting pixel (row and column) of the flood fill, and a pixel
// value newColor, “flood fill” the image.
//
// To perform a “flood fill”, consider the starting pixel, plus any pixels connected
// 4-directionally to the starting pixel of the same colour as the starting pixel,
// plus any pixels connected 4-directionally to those pixels (also with the same
// colour as the starting pixel), and so on. Replace the colour of all of the
// aforementioned pixels with the newColor.
//
// Pre-req: Connected Components, Graph traversal techniques

//The algorithm steps are as follows:
//
//        Initial DFS call will start with the starting pixel (sr, sc)
//        and make sure to store the initial colour.

//        Now, either we can use the same matrix to replace the colour of all of the
//        aforementioned pixels with the newColor or create a replica of the given matrix.
//        It is advised to use another matrix because we work on the data and not tamper
//        with it. So we will create a copy of the input matrix.

//        Check for the neighbours of the respective pixel that has the same initial
//        colour and has not been visited or coloured. DFS call goes first in the depth
//        on either of the neighbours.

//        We go to all 4 directions and check for unvisited neighbours with the same
//        initial colour. To travel 4 directions we will use nested loops, you can find
//        the implementation details in the code.

//        DFS function call will make sure that it starts the DFS call from that
//        unvisited neighbour, and colours all the pixels that have the same initial
//        colour, and at the same time it will also mark them as visited.

// Time Complexity: O(NxM + NxMx4) ~ O(N x M)
//
//        For the worst case, all of the pixels will have the same colour,
//        so DFS function will be called for (N x M) nodes and for every
//        node we are traversing for 4 neighbours, so it will take O(N x M x 4) time.
//
// Space Complexity: O(N x M) + O(N x M)
//
//        O(N x M) for copied input array and recursive stack space takes up N x M locations at max.
public class image {
    private static void dfs(int srRow, int srCol,
                            int[][] ans, int[][] image,
                            int newColor, int initialCol,
                            int[] deltaRow, int[] deltaCol){
        ans[srRow][srCol] = newColor;
        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i<4; i++){
            int neighRow = srRow + deltaRow[i];
            int neighCol = srCol + deltaCol[i];

            if(neighRow>=0 && neighRow <n
            && neighCol>=0 && neighCol <n
            && image[neighRow][neighCol]==initialCol
            && ans[neighRow][neighCol] != newColor){
                dfs(neighRow, neighCol,ans, image, newColor,initialCol, deltaRow, deltaCol);
            }
        }
    }
     public static int[][] images(int srRow, int srCol, int newCol, int[][] image, int[] delr, int[]delc){
        int initialCol = image[srRow][srCol];
        int[][] ans = image;
        dfs(srRow, srCol, ans, image, newCol, initialCol, delr, delc);
        return ans;
     }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[][] image =  {
                {1,1,1},
                {2,2,0},
                {2,2,2}
        };

        int sourceRow = 2;
        int sourceCol = 0;
        int newColor = 3;

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, +1, 0, -1};

        int[][] ans = images(sourceRow, sourceCol, newColor, image,deltaRow, deltaCol);

        for(int[] row: ans){
            for(int i: row){
                System.out.print(i + " ");
            }
            System.out.println();
        }



        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
