package DP.String;

// note
//Steps to memoize a recursive solution:
//
//        As we see there are overlapping subproblems in the recursive tree, we can memorize the recursive
//        code to reduce the time complexity.
//
//        Create a dp array of size [N][M] where N and M are lengths of S1 and S2 respectively. It will store
//        all the possible different states that our recursive function will take.

//        We initialize the dp array to -1.
//        Whenever we want to find the answer of particular parameters (say f(ind1,ind2)), we first check
//        whether the answer is already calculated using the dp array(i.e dp[ind][ind2]!= -1 ). If yes,
//        simply return the value from the dp array.

import java.lang.reflect.Array;
import java.util.Arrays;

//        If not, then we are finding the answer for the given value for the first time,
//        we will use the recursive relation as usual but before returning from the function,
//        we will set dp[ind][ind2] to the solution we get.
public class longestCommonSub {
    public static int longest(int ind1, int ind2, String sub1, String sub2) {
        // this is base case, where if ind1 and ind2 are less than 0, that means the sequence is over
        // hence we return a 0, because there are no characters left to compare.
        if(ind1<0 || ind2<0) return 0;

        // here as we find a matching character, we return a 1 because we will increase this with recursion.
        //so that the longest subsequence is found.
        if(sub1.charAt(ind1)==sub2.charAt(ind2)) return 1 + longest(ind1-1, ind2-1, sub1, sub2);

        //if the all the above conditions fail, then
        // we will either move ind1 or move ind2, and return the maximum of them.
        return Math.max(longest(ind1-1, ind2, sub1, sub2), longest(ind1, ind2-1, sub1, sub2));

    }
    public static int longestDP(int ind1, int ind2, String sub1, String sub2, int[][] dp) {
        // this is base case, where if ind1 and ind2 are less than 0, that means the sequence is over
        // hence we return a 0, because there are no characters left to compare.
        if(ind1<0 || ind2<0) return 0;


        //DP wala condition
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        // here as we find a matching character, we return a 1 because we will increase this with recursion.
        //so that the longest subsequence is found.
        if(sub1.charAt(ind1)==sub2.charAt(ind2)) return dp[ind1][ind2]= 1 + longestDP(ind1-1, ind2-1, sub1, sub2, dp);

        //if the all the above conditions fail, then
        // we will either move ind1 or move ind2, and return the maximum of them.
        return dp[ind1][ind2]=  Math.max(longest(ind1-1, ind2, sub1, sub2), longestDP(ind1, ind2-1, sub1, sub2, dp));

    }

    public static int longTab(int n, int m, String sub1, String sub2){
        int dp[][]=new int[n+1][m+1];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(sub1.charAt(i-1)==sub2.charAt(j-1)){
                    dp[i][j]  = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }


        return dp[n][m];
    }
    public static void main(String[] args) {

        String s1= "acd";
        String s2= "ced";

        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] k: dp) Arrays.fill(k, -1);
        long startTime = System.nanoTime();



        System.out.println(longest(s1.length()-1, s2.length()-1, s1, s2));
        System.out.println(longestDP(s1.length()-1, s2.length()-1, s1, s2, dp));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");

        startTime = System.nanoTime();

        System.out.println(longTab(s1.length(), s2.length(), s1, s2));

       endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
