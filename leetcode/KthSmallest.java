package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {

    public static int ksmall(int[] arr, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0; i<arr.length; i++){
            pq.add(arr[i]);
            if(pq.size()>k) pq.remove();
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

       int[] arr = {3,2,1,5,6,4};

      System.out.println( ksmall(arr, 3));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
