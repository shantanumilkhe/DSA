package DP.subsets;
//note
//A subset/subsequence is a contiguous or non-contiguous part of an array, where elements appear in the same order
// as the original array.
//For example, for the array: [2,3,1] , the subsequences will be [{2},{3},{1},{2,3},{2,1},{3,1},{2,3,1}} but {3,2}
// is not a subsequence because its elements are not in the same order as the original array.

//question
//We are given an array ‘ARR’ with N positive integers.We need to find if there is a subset in “ARR” with a
// sum equal to K. If there is, return true else return false.

//steps to write the recursion for any subsequence question
// 1. express the problem in terms (ind, target)
// 2. write the base cases
// 3. try out all the possible choices at a given index.
// 4. return the obtained solution

import java.util.Arrays;

public class equalToK {

    //recursion
    // here, k is the target, which will be reduced to 0. and ind is the index.
    public static boolean sumk(int ind,int k,int[] arr){
        // if k is 0, it means we have found our solution.
        if(k==0) return true;
        // if we are at the last index, then it should be equal to k,
        // otherwise we haven't been able to find the solution
        if(ind <=0){
            if(arr[ind]==k) return true;
            else return false;
        }
        // then we could either pick the index or we could choose not to pick that element.
        boolean not_pick = sumk(ind-1, k, arr);
        boolean pick = false;
        if(k>=arr[ind]) pick = sumk(ind-1, k-arr[ind],arr);
        // if any of the value returns true, we return true to the previous call.
        return pick || not_pick;
    }

    public static boolean sumkDP(int ind,int k,int[] arr, int[][] dp){
        // if k is 0, it means we have found our solution.
        if(k==0) return true;
        // if we are at the last index, then it should be equal to k,
        // otherwise we haven't been able to find the solution
        if(ind <=0){
            if(arr[ind]==k) return true;
            else return false;
        }
        // dp will always be a int, because we can only represent two states with boolean, so to return boolean
        // we do this tam jham
        if(dp[ind][k] != -1) return dp[ind][k]==1 ? true : false;
        // then we could either pick the index or we could choose not to pick that element.
        boolean not_pick = sumkDP(ind-1, k, arr,dp);
        boolean pick = false;
        if(k>=arr[ind]) pick = sumkDP(ind-1, k-arr[ind],arr, dp);

        // same tam jham is here.
        dp[ind][k] = not_pick||pick?1:0;

        // if any of the value returns true, we return true to the previous call.
        return pick || not_pick;
    }
    // not understood
    public static boolean sumkTab(int k, int[] arr){
        // here we can use boolean because don't need to return some value here as their is no recursion.
        boolean[][] dp = new boolean[arr.length][k+1];
        for(boolean[] sub: dp){
            Arrays.fill(sub, false);
        }
        // we are doing this because, our dp array is 2d, where 1 d is about columns and other is about what is the
        // target we have achieved so far.
        // thus, for every index if target is 0, we set the dp as true.
        // this is the first base case we converted.
        for (int i=0; i<arr.length; i++) dp[i][0] = true;

        // this is the second base case we are converting.
        // if arr[0] is smaller than equal to k, then dp at 0th index
        // and column arr[0] will be true.
        if(arr[0]<=k) dp[0][arr[0]] = true;

        // run two for loops
        for(int ind = 1; ind< arr.length; ind++){
            for(int target= 1; target<=k; target++){

                boolean notTaken = dp[ind-1][target];

                boolean taken = false;
                if(arr[ind]<=target)
                    taken = dp[ind-1][target-arr[ind]];

                dp[ind][target]= notTaken||taken;
            }
        }
        return dp[arr.length-1][k];
    }


    public static void main(String[] args) {
        long startTime = System.nanoTime();
int k = 4;
        int[] arr = {2, 5, 1, 6, 7};
        int[][] dp = new int[arr.length][k+1];
        for(int[] sub: dp){
            Arrays.fill(sub, -1);
        }

        //System.out.println(sumk(arr.length-1, k, arr));
        System.out.println(sumkDP(arr.length-1, k, arr, dp));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
