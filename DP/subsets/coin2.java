package DP.subsets;

import java.util.Arrays;

public class coin2 {

    public static int coinrec(int n, int t, int[] coin){

        if(n==0){
            return  (t % coin[0] == 0) ? 1:0;
        }

        int not_take = coinrec(n-1, t, coin);
        int take = 0;
        if(coin[n]<=t){
            take = coinrec(n, t-coin[n], coin);
        }
        return not_take+take;
    }

    public static int coinDD(int n, int t, int[] coin, int[][] dp){

        if(n==0){
            return  (t % coin[0] == 0) ? 1:0;
        }

        if(dp[n][t] !=-1) return dp[n][t];

        int not_take = coinrec(n-1, t, coin);
        int take = 0;
        if(coin[n]<=t){
            take = coinrec(n, t-coin[n], coin);
        }

        return dp[n][t] = not_take+take;
    }

    public static long conTab(int n, int t, int[] coin ){
        long dp[][]=new long[n][t+1];
        for(int i=0; i<=t; i++){
           if(i%coin[0]==0) dp[0][i] = 1;
        }

        for(int i =1; i<n; i++){
            for(int tar = 0; tar<=t; tar++){
                 long not_take = dp[i-1][tar];
                 long take = 0;
                 if(coin[i]<=tar) take = dp[i][tar-coin[i]];
                dp[i][tar] = not_take+take;
            }

        }
        return dp[n-1][t];
    }


    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] arr = {1,2,3};
        int n = arr.length;
        int t = 4;
       System.out.println(coinrec(n-1,t,arr));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");

        int[][] dp = new int[n][t+1];
        for(int[] sub:dp) Arrays.fill(sub, -1);
        startTime = System.nanoTime();


        System.out.println(coinDD(n-1,t,arr,dp));

       endTime = System.nanoTime();
       duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");

        startTime = System.nanoTime();

        System.out.println(conTab(n,4,arr));

        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
