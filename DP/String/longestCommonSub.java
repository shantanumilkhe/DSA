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
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        String s1= "acd";
        String s2= "ced";

        System.out.println(longest(s1.length()-1, s2.length()-1, s1, s2));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
