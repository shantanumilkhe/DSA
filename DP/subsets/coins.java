package DP.subsets;

import java.util.Arrays;

public class coins {

    public static int coins(int n, int target, int[] coins){
        if(n==0){
           if(target%coins[0]==0){
               return target/coins[0];
           }
           else return (int)Math.pow(10,9);
        }

        int not_take = not_take=coins(n-1, target, coins);;;
        int take = (int)Math.pow(10,9);
        if(coins[n]<= target){
            take = 1+coins(n, target-coins[n], coins);
        }

        return Math.min(take,not_take);
    }

    public static int coinsDP(int n, int target, int[] coins, int[][]dp){
        if(n==0){
            if(target%coins[0]==0){
                return target/coins[0];
            }
            else return (int)Math.pow(10,9);
        }
        if(dp[n][target]!=-1) return dp[n][target];
        int not_take = not_take=coinsDP(n-1, target, coins, dp);
        int take = (int)Math.pow(10,9);
        if(coins[n]<= target){
            take = 1+ coins(n, target-coins[n], coins);
        }

        return dp[n][target]= Math.min(take,not_take);
    }

    public static int coinsTab(int n, int target, int[] coins, int[][]dp){
        for(int i =0; i<=target; i++){
            if(i%coins[0]==0){
                dp[0][i] = i/coins[0];
            }else{
               dp[0][i] = (int) Math.pow(10,9);
            }
        }
        for(int ind =1; ind<n; ind++){
            for(int tar = 0; tar<=target; tar++){
                int not_take = dp[ind-1][tar];
                int take = (int) Math.pow(10,9);
                if(coins[ind]<=tar){
                    take = 1+ dp[ind][tar-coins[ind]];
                }
                dp[ind][tar] = Math.min(take, not_take);
            }
        }
        return dp[n-1][target];
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] coins = {1, 2, 3};
        int target = 7;
        System.out.println(coins(coins.length-1, target, coins));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");


        int[][] dp = new int[coins.length][target+1];
        for(int[] sub: dp) Arrays.fill(sub, -1);
        startTime = System.nanoTime();

        System.out.println(coinsDP(coins.length-1, target, coins, dp));
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");

        for(int[] sub: dp) Arrays.fill(sub, 0);
        startTime = System.nanoTime();

        System.out.println(coinsTab(coins.length, target, coins, dp));
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
