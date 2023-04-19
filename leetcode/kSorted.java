package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class kSorted {

    public static void kSort(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i =0; i<arr.length; i++){
            pq.add(arr[i]);
            if(pq.size()>k) ans.add(pq.poll());
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Write your code here

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
