package DP.Grid;

//Question
//We are given an ‘N*M’ matrix. Every cell of the matrix has some chocolates on it, mat[i][j] gives us the number of
// chocolates. We have two friends ‘Alice’ and ‘Bob’. initially, Alice is standing on the cell(0,0) and Bob is standing
// on the cell(0, M-1). Both of them can move only to the cells below them in these three directions: to the bottom cell
// (↓), to the bottom-right cell(↘), or to the bottom-left cell(↙).
//
//When Alica and Bob visit a cell, they take all the chocolates from that cell with them. It can happen that they visit
// the same cell, in that case, the chocolates need to be considered only once.
//
//They cannot go out of the boundary of the given matrix, we need to return the maximum number of chocolates that Bob
// and Alice can together collect

import java.util.Arrays;

public class DP_3D {
    // we are taking three parameters because alice and bob should move together, because if they move separately i:e,
    // if we make two different recursion calls, it would be very difficult to track the same cells that they visited.

    public static int choco(int i, int j1, int j2, int n, int m, int[][] arr){
        //this is out of bound condition, as, we cannot go out of bounds on left and right, top and down are
        // already bounded.
        if (j1<0 || j1>=m || j2<0 || j2>=m) return (int) Math.pow(-10, 9);
        //base case. if both alice and bob are at same cell, then we return the value only once
        // other wise we add the values of different cells which alice and bob are on
        if(i== n-1){
            if(j1==j2) return arr[i][j1];
            else return arr[i][j1] + arr[i][j2];
        }
        // here total 9 different combos can be created when changing the row
        // when alice moves down, bob can make 3 times of moves, and so on.so total is nine
        // we can write all those combos down like a fucking wanker, or we can smartly do this with a loop,
        // we created a list type of column movement. and made the loop. understand it yourself, pussio.
        int[] col = {-1, 0, 1};
        int max = 0;
        for(int a =0; a<col.length; a++){

            for(int b = 0; b<col.length; b++){
            if(j1==j2){
                max =Math.max(max,(arr[i][j1] + choco(i+1, j1+col[a], j2+col[b], n, m, arr)));
            }else{
                max =Math.max(max,(arr[i][j1]+arr[i][j2] + choco(i+1, j1+col[a], j2+col[b], n, m, arr)));
            }
            }
        }
        return max;
    }

    public static int chocoDP(int i, int j1, int j2, int n, int m, int[][] arr, int[][][] dp){
        //this is out of bound condition, as, we cannot go out of bounds on left and right, top and down are
        // already bounded.
        if (j1<0 || j1>=m || j2<0 || j2>=m) return (int) Math.pow(-10, 9);
        //base case. if both alice and bob are at same cell, then we return the value only once
        // other wise we add the values of different cells which alice and bob are on
        if(i== n-1){
            if(j1==j2) return arr[i][j1];
            else return arr[i][j1] + arr[i][j2];
        }

        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];

        // here total 9 different combos can be created when changing the row
        // when alice moves down, bob can make 3 times of moves, and so on.so total is nine
        // we can write all those combos down like a fucking wanker, or we can smartly do this with a loop,
        // we created a list type of column movement. and made the loop. understand it yourself, pussio.
        int[] col = {-1, 0, 1};
        int max = 0;
        for(int a =0; a<col.length; a++){

            for(int b = 0; b<col.length; b++){
                if(j1==j2){
                    max =Math.max(max,(arr[i][j1] + chocoDP(i+1, j1+col[a], j2+col[b], n, m, arr, dp)));
                }else{
                    max =Math.max(max,(arr[i][j1]+arr[i][j2] + chocoDP(i+1, j1+col[a], j2+col[b], n, m, arr,dp)));
                }
            }
        }
        return dp[i][j1][j2] = max;
    }


    public static void main(String[] args) {
        long startTime = System.nanoTime();

       int[][] arr = {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};
       int n = arr.length;
       int m = arr[0].length;
       System.out.println(n+ " "+m);
       int[][][] dp = new int[n][m][m];
       for(int[][]d2 : dp){
           for(int[]d1 : d2){
               Arrays.fill(d1, -1);
           }
       }

       //System.out.println(choco(0,0,m-1,n, m, arr));
        System.out.println(chocoDP(0, 0, m-1, n, m, arr,dp));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
