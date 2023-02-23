package DP.Grid;

import java.util.Arrays;

public class MinimumPathSum {
    //recursion
    public static int sumPath(int m, int n, int[][] country){
        // declaring a base case
        // if we reach the starting point, we return the value of that point as
        // we are finding the minimum and not counting.
        if (m==0 && n==0) return country[0][0];
        // if we are out of bounds, then return big ass value.
        if (m<0 || n<0) return (int)Math.pow(10,9);

        // then check which is minimum going left or right(not greedy).
        // we explore all the possibilities
        int left = country[m][n] + sumPath(m, n-1, country);
        int up = country[m][n] + sumPath(m-1, n, country);

        return Math.min(left, up);
    }
    // dp
    public static int sumPathDP(int m, int n, int[][] country, int[][] dp){
        if (m==0 && n==0) return country[0][0];
        if (m<0 || n<0) return (int)Math.pow(10,9);

        if(dp[m][n] != -1) return dp[m][n];
        int left = country[m][n] + sumPathDP(m, n-1, country, dp);
        int up = country[m][n] + sumPathDP(m-1, n, country, dp);

        return dp[m][n] =  Math.min(left, up);
    }
    // tabulation
    public static int tab(int m, int n, int[][]matrix, int[][]dp){


        for (int i= 0; i<m;i++){
            for (int j=0; j<n; j++){
                if(i==0 && j==0){
                    dp[0][0] = matrix[0][0];
                }
                else {
                    int up = matrix[i][j];
                    if(i>0) up += dp[i-1][j];
                    else up += (int)Math.pow(10,9);

                    int left = matrix[i][j];
                    if(j>0) left+=dp[i][j-1];
                    else left += (int)Math.pow(10,9);

                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[][] country = {{5,9,6},{11,5,2}};;
        int m = country.length;
        int n = country[0].length;
        int[][] dp = new int[m][n];
        for(int[] SubArray: dp) Arrays.fill(SubArray, -1);

       // System.out.println(sumPath(m-1, n-1, country));
        //System.out.println(sumPathDP(m-1, n-1, country, dp));
        System.out.println(tab(m, n, country, dp));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
