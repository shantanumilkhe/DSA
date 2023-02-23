package DP.subsets;

import java.util.Arrays;

public class zero1Knapsack {

    public static int knap(int n, int w, int[][] arr){
        if(w<=0) return 0;
        if(n==0) {
            if(arr[0][0] <= w){
                return arr[1][0];
            }
            return 0;
        }

        int not_take =  knap(n-1, w, arr);
        int take = Integer.MIN_VALUE;
        if(arr[0][n]<=w){
            take = arr[1][n] + knap(n-1, w-arr[0][n], arr);
        }

        return Math.max(take, not_take);
    }

    public static int knapDP(int n, int w, int[][] arr, int[][] dp){
        if(w<=0) return 0;
        if(n==0) {
            if(arr[0][0] <= w){
                return arr[1][0];
            }
            return 0;
        }
        if(dp[n][w]!= -1) return dp[n][w];
        int not_take =  knapDP(n-1, w, arr, dp);
        int take = Integer.MIN_VALUE;
        if(arr[0][n]<=w){
            take = arr[1][n] + knapDP(n-1, w-arr[0][n], arr, dp);
        }

        return dp[n][w] = Math.max(take, not_take);
    }

    public static int knapTab(int n, int w, int[][] arr, int[][] dp){
        for(int i = arr[0][0]; i<=w; i++){
            dp[0][i] = arr[1][0];
        }
        for (int i = 1; i<n; i++){
            for(int j = 1; j<=w; j++){
                int not_take = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(arr[0][i]<=j){
                    take = arr[1][i] + dp[i-1][j-arr[0][i]];
                }
                dp[i][j] = Math.max(take, not_take);
            }
        }
        return dp[n-1][w];
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[][] items = {{1, 2, 4, 5} ,{5, 4, 8, 6}};
        int w = 5;

        System.out.println(knap(3, w, items));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");

        // DP memo
        int[][] dp = new int[items[1].length][w+1];
        for (int[] sub:dp) Arrays.fill(sub, -1);
         startTime = System.nanoTime();

        System.out.println(knapDP(3, w, items, dp));

        endTime = System.nanoTime();
         duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");


        for (int[] sub:dp) Arrays.fill(sub, -1);
        startTime = System.nanoTime();

        System.out.println(knapTab(3, w, items, dp));

        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
