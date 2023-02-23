package DP.subsets;

import java.util.Arrays;

public class equal_subset {

    public static boolean equal(int n, int[] arr){
        int sum = 0;
        for(int k: arr){
            sum = sum+k;
        }
        int k = sum/2;
        System.out.println(sum + " "+ k + " ");
        if(sum%2==0) {
            int[][] dp = new int[arr.length][k+1];
            for(int[] sub: dp){
                Arrays.fill(sub, -1);
            }
            return equalToK.sumkDP(n-1, k, arr,dp);
        }
        return false;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] arr ={3, 1, 1, 2, 2,1};
        System.out.println(equal(6, arr));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
