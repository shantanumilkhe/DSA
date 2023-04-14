package DP.String;
//question
// There can be many subsequences like “b”, “ba”,”bbb” but “bbbb” is the subsequence
// that is a palindrome and has the greatest length.
// We need to print the length of the longest palindromic subsequence.
public class longestPalindromic {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        //this is a variation of longest common subsequence problem.
        //here we simply reverse the given string and pass it to the same function of
        //longest common subsequence problem.
        String s1 = "bbbab";
        StringBuilder ss = new StringBuilder(s1);
        ss.reverse();
        String s2= ss.toString();
        System.out.println(longestCommonSub.longTab(s1.length()-1,s2.length()-1,s1, s2));
        printingSub.lcs(s1.length(),s2.length(),s1, s2);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
