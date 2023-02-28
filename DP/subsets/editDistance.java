package DP.subsets;

import java.util.Arrays;

public class editDistance {

    public static int edit(int i, int j, String s1, String s2, int[][]dp){
        if(i<0) return j+1;
        if(j<0) return i+1;


        if(dp[i][j]!= -1) return dp[i][j];
        // if i and j are equal we move forward in both the strings.
        if(s1.charAt(i)==s2.charAt(j)) return edit(i-1, j-1, s1, s2, dp);

        // if we insert a new character in string 1, which would be obviously equal to j in string 2
        // then we would move on j as we inserted the letter after the i, so the i got shifted and
        // we won't move it.
        int insert = 1 + edit(i, j-1, s1, s2, dp);

        // if we delete a letter, then we will move forward in the s1 only.
        int delete = 1+ edit(i-1, j, s1, s2, dp);

        // replacing a character will result in changing both i and j.
        int replace = 1 + edit(i-1, j-1, s1, s2, dp);

        // we will return min of the three.
        return dp[i][j]= Math.min(Math.min(insert, delete), replace);
    }
    public static void main(String[] args) {

        String s1 = "horse";
        int n = s1.length();
        String s2 = "ros";
        int m = s2.length();

        int[][]dp = new int[n][m];
        for(int[] a: dp) Arrays.fill(a, -1);


        long startTime = System.nanoTime();

        System.out.println(edit(n-1, m-1, s1, s2, dp));


        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
