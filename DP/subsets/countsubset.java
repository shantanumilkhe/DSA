package DP.subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class countsubset {

    // recursion
    public static int countset(int n, int k, int[] arr) {

        if (k == 0) return 1;
        if (n == 0) {
            if (arr[0] == k) return 1;
            else return 0;
        }
        int not_take = countset(n - 1, k, arr);
        int take = 0;
        if (arr[n] <= k) take = countset(n - 1, k - arr[n], arr);
        return take + not_take;
    }

    public static int countsetDP(int n, int k, int[] arr, int[][] dp) {

        if (k == 0) return 1;
        if (n == 0) {
            if (arr[0] == k) return 1;
            else return 0;
        }
        if (dp[n][k] != -1) return dp[n][k];

        int not_take = countsetDP(n - 1, k, arr, dp);
        int take = 0;
        if (arr[n] <= k) take = countsetDP(n - 1, k - arr[n], arr, dp);

        return dp[n][k] = take + not_take;
    }

    public static int countsetTab(int n, int k, int[] arr, int[][] dp) {

        for (int i = 0; i < arr.length; i++) dp[i][0] = 1;
        if (arr[0] <= k) dp[0][arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int not_take = dp[i - 1][j];
                int take = 0;
                if (arr[i] <= j) {
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = take + not_take;
            }
        }
        return dp[n - 1][k];
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] arr = {1, 2, 2, 3};
        int k = 3;
        System.out.println(countset(arr.length - 1, k, arr));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");

        startTime = System.nanoTime();

        int[][] dp = new int[arr.length][k + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(countsetDP(arr.length - 1, k, arr, dp));

        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");


        startTime = System.nanoTime();

        for (int[] a : dp) {
            Arrays.fill(a, 0);
        }
        System.out.println(countsetTab(arr.length , k, arr, dp));

        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
