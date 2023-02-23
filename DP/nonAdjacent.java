package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nonAdjacent {
    static int target = 12;
    //recursion

    public static int nonad(int ind ,   int[] arr) {
        if(ind==0){

            return arr[ind];
        }
        if(ind<0){
            return 0;
        }
        int pick = Integer.MIN_VALUE;
        int notPick = Integer.MIN_VALUE;

        pick =  arr[ind] + nonad(ind - 2,  arr);

        notPick =  nonad(ind - 1,  arr);

        return Math.max(pick, notPick);
    }

    //memoization
    public static int nonadDPM(int ind , int[] arr, int[] dp) {
        if(ind==0){

            return arr[ind];
        }
        if(ind<0){
            return 0;
        }
        int pick = Integer.MIN_VALUE;
        int notPick = Integer.MIN_VALUE;

        if(dp[ind]!=-1) return dp[ind];
        pick =  arr[ind] + nonadDPM(ind - 2,  arr,dp);

        notPick =  nonadDPM(ind - 1,  arr,dp);

        return dp[ind] =  Math.max(pick, notPick);
    }
    //tabulation
    public static int nonadTAB(int ind, int[] arr, int[] dp){
        dp[0] = arr[0];
        int neg = 0;
        for (int i = 2; i<arr.length; i++){
            int pick = arr[i];
            if(i>1) pick += dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[ind];
    }

    public static void main(String[] args ){
        long startTime = System.nanoTime();

        int[] arr =  {2, 1, 4, 9};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(nonad(arr.length-1,  arr));
        System.out.println(nonadDPM(arr.length-1, arr, dp));
        System.out.println(nonadTAB(arr.length-1, arr, dp));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ms");
    }

}
