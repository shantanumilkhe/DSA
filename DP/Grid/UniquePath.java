package DP.Grid;

import java.util.Arrays;

public class UniquePath {
    // recursion
    public static int PathRec(int m, int n){
        // we have reached the starting position from the m-1 and n-1 cell.
        // so return 1, as we have successfully found a new way.
        if(m==0 && n == 0) return 1;
        // if m and n go out of bounds then return 0.
        if(m<0 || n< 0) return 0;

        // now the question says that we can go down or right, so if we are starting from the end,
        // we would mirror the movement by going up instead of down and going left instead of a right.

        int right = PathRec(m-1, n);
        int up = PathRec(m, n-1);

        return up+right;
    }
    //DP- Memoization
    public static int PathMem(int m, int n, int[][] dp){
        // we have reached the starting position from the m-1 and n-1 cell.
        // so return 1, as we have successfully found a new way.
        if(m==0 && n == 0) return 1;
        // if m and n go out of bounds then return 0.
        if(m<0 || n< 0) return 0;

        // now the question says that we can go down or right, so if we are starting from the end,
        // we would mirror the movement by going up instead of down and going left instead of a right.
        if(dp[m][n]!=-1) return dp[m][n];
        int right = PathMem(m-1, n, dp);
        int up = PathMem(m, n-1, dp);

        return dp[m][n] = up+right;
    }

    // tabulation
    public static int PathTab(int m, int n, int[][] dp){
        // to convert the problem in tabulation, mimic the recursion using for loops.
        // inside the for loops, copy the recursion and instead of calls, use the DP array
        // after the loops are completed, return dp[m][n]; or the last element of the dp array.
        for (int i = 0; i<=m; i++){
            for(int j =0; j<=n; j++){
                if(i==0 && j ==0){
                    dp[0][0] =1;
                    continue;
                }
                int left = 0;
                int down = 0;
                if(i>0) left = dp[i-1][j];
                if(j>0) down = dp[i][j-1];
                dp[i][j]= left+down;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int m = 4;
        int n = 4;
        int[][] dp = new int[m][n];
        for(int[] SubArray: dp) Arrays.fill(SubArray, -1);

        //System.out.println(PathRec(22,11));
        //System.out.println(PathMem(m-1, n-1, dp));
        System.out.println(PathTab(m-1, n-1, dp));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}

// question link
// https://www.codingninjas.com/codestudio/problems/total-unique-paths_1081470?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
