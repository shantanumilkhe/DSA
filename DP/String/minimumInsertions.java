package DP.String;

public class minimumInsertions {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        String s1= "abcaa";
        StringBuilder ss = new StringBuilder(s1);
        String s2 = ss.reverse().toString();
        int longest_Palindromic_Subsequence = longestCommonSub.longTab(s1.length(), s2.length(), s1, s2);
        int n = s1.length()-longest_Palindromic_Subsequence;
        int m = s2.length() - longest_Palindromic_Subsequence;
        System.out.println(n+m);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
