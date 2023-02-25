package DP.String;

import java.util.Arrays;

public class printingSub {

    public static void lcs(int n, int m, String sub1, String sub2){
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

        int i = sub1.length();
        int j = sub2.length();
        String ans = "";

        while(i>0 && j>0){
            if(sub1.charAt(i-1)==sub2.charAt(j-1)){
                ans = ans+ sub1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        System.out.println(ans);
        String fans = "";
        for(int o=ans.length()-1; o>=0;o--){
            fans = fans+ans.charAt(o);
        }
        System.out.println(fans);
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

       String s1 = "abcde";
       String s2 = "bdgek";
      lcs(s1.length(), s2.length(), s1, s2);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
