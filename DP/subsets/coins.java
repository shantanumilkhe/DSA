package DP.subsets;

import java.util.Arrays;

//We are given a target sum of ‘X’ and ‘N’ distinct numbers denoting the coin denominations.
// We need to tell the minimum number of coins required to reach the target sum. We can pick
// a coin denomination for any number of times we want.


//Steps to form the recursive solution:
//
//        We will first form the recursive solution by the three points mentioned in Dynamic
//        Programming Introduction.
//
//        Step 1: Express the problem in terms of indexes.
//
//        We are given ‘n’ distinct numbers. Their denomination is represented by the ‘arr’ array
//        . So clearly one parameter will be ‘ind’, i.e index up to which the array items are being
//        considered.
//
//        There is one more parameter “T”. We need to know the given target that we want to achieve.
//
//        So, we can say that initially, we need to find f(n-1, T) where T is the initial target given
//        to us. f(n-1, T) means we are finding the minimum number of coins required to form the targe
//        t sum by considering coins from index 0 to n-1.
//
//        Base Cases:
//
//        If ind==0, it means we are at the first item, so in that case, the following cases can arise:
//
//        arr[0] = 4 and T = 12
//
//        In such a case where the target is divisible by the coin element, we will return T%arr[0].
//
//        arr[0] =4 and T=1 , arr[0]=3 T=10
//
//        In all other cases, we will not be able to form a solution, so we will return a big number like 1e9
//
//        Step 2: Try out all possible choices at a given index.
//
//        We need to generate all the subsequences. We will use the pick/non-pick technique as
//        discussed in this video “Recursion on Subsequences”. There will be a slight change for
//        this question which is discussed below.
//
//        We have two choices:
//
//        Exclude the current element in the subsequence: We first try to find a subsequence without
//        considering the current index coin. If we exclude the current coin, the target sum will not
//        be affected and the number of coins added to the solution will be 0. So we will call the
//        recursive function f(ind-1,T)

//        Include the current element in the subsequence: We will try to find a subsequence by considering
//        the current icoin. As we have included the coin, the target sum will be updated to T-arr[ind]
//        and we have considered 1 coin to our solution.
//
//        Now here is the catch, as there is an unlimited supply of coins, we want to again form a
//        solution with the same coin value. So we will not recursively call for f(ind-1, T-arr[ind])
//        rather we will stay at that index only and call for f(ind, T-arr[ind]) to find the answer.

//        Note: We will consider the current coin only when its denomination value (arr[ind])
//        is less than or equal to the target T.
//
//        Step 3:  Return the minimum of take and notTake
//
//        As we have to return the minimum number of coins, we will return the minimum
//        of take and notTake as our answer.

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
