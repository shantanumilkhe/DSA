package DP.String;

import java.util.Arrays;

public class distinctSubsequences  {
    public static int dis(int ind1, int ind2, String s1, String s2, int[][] dp){
        if(ind2<0) return 1;
        if(ind1<0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2] = dis(ind1-1, ind2-1, s1, s2, dp) + dis(ind1-1, ind2, s1, s2, dp);
        }
        else{
            return dp[ind1][ind2] =dis(ind1-1, ind2, s1, s2, dp);
        }

    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        String s1 = "babgbag";
        String s2 = "bag";
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] a: dp) Arrays.fill(a, -1);

        System.out.println(dis(s1.length()-1, s2.length()-1, s1, s2, dp));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
