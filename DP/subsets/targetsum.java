package DP.subsets;

public class targetsum {
    public static int targetsum(int n, int target, int[] arr){
        if(target==0) return 1;
        if(n==0){
            if(arr[0]== target) return 1;
            else return 0;
        }
        int negative = targetsum(n-1, target-arr[n], arr);
        int positive = targetsum(n-1, target+arr[n], arr);

       return negative+positive;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Write your code here

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
