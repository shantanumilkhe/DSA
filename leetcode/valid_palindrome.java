package leetcode;

public class valid_palindrome {

    public static boolean isPalindrome(String s) {

        int i = 0;

        s= s.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int j = s.length()-1;
        System.out.println(s);
        for(int k =0; k<(s.length())/2 + 1; k++){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        System.out.println(isPalindrome(" "));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
