package leetcode;

import java.util.Arrays;

public class leet228 {

    public static int[] pr(int[] nums){
        int n= nums.length;
        int[] output = new int[n];
        Arrays.fill(output, 1);
        int pre = 1;
        for(int i =0; i<n; i++){
            output[i]= pre;
            pre *= nums[i];
        }
        int post = 1;
        for(int i =n-1; i>=0; i--){
            output[i]= post*output[i];
            post = post*nums[i];
        }

        return output;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Write your code here

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
