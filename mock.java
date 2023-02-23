import java.util.HashMap;

public class mock {

    public static void dup(int[] arr, int n){

    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();


        // Write your code here

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}

// 1, 1, 2, 2, 3
// remove duplicates