package DP.subsets;

import java.util.Arrays;

public class countPartitions {
    static int mod =(int)(Math.pow(10,9)+7);

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int arr[] = {1, 1, 1, 1};
        int sum =0;
        for(int a: arr){
            sum = sum +a;
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
