package DP.String;

import java.util.Arrays;

public class wildcard {

    public static int wild(int i, int j, String s1, String s2, int[][] dp){

        if(i<0 && j<0) return 1;
        if(i<0 && j>=0) return 0;
        if(j<0 && i>=0){
            for(int k =0; k<=i; i++){
                if(s1.charAt(k)!='*') return 0;
            }
            return 1;
        }
        if(dp[i][j] !=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i) == '?'){
            return dp[i][j] = wild(i-1, j-1, s1, s2, dp);
        }

        if(s1.charAt(i)=='*'){
            return (wild(i-1, j, s1, s2, dp)==1 || wild(i, j-1, s1, s2, dp)==1) ? 1 : 0;
        }
        else return 0;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        String S1 = "ab*cd";
        String S2 = "abdefcd";
        int[][] dp = new int[S1.length()][S2.length()];
        for(int[] a : dp) Arrays.fill(a, -1);

        if (wild(S1.length()-1, S2.length()-1, S1, S2, dp) == 1)
            System.out.println("String S1 and S2 do match");
        else System.out.println("String S1 and S2 do not match");

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
