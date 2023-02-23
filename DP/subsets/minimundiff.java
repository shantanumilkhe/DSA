package DP.subsets;

import java.util.Arrays;

public class minimundiff {


    public static int minTab(int k, int[] arr){
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

        // once the dp is generated, in the n-1 row of the dp, there will be value of k that was possible.
        // so if for ex, dp[n-1][1] is true, then we will do the loop thing.

        int mini = (int) Math.max(-10,9);
        for (int i=0; i<= k/2; i++){
            if(dp[arr.length - 1][i]){
                int diff = Math.abs(i - (k - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;

    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int arr[] = {1, 2, 3, 4};
        int sum =0;
        for(int a: arr){
            sum = sum +a;
        }
        System.out.println(minTab(sum, arr));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
