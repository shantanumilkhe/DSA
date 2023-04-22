package leetcode;

import java.util.*;

class Pair{
    int diff, value;
    public Pair(int diff, int value){
        this.diff = diff;
        this.value = value;
    }
}
public class KClosest {

    public static void closest(int[] arr, int k, int t){
        int n = arr.length;
        int[] diff = new int[n];
        for(int i =0; i<n; i++){
            diff[i]  = Math.abs(arr[i]-t);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder((x,y)->(x.diff-y.diff)));

        for(int i =0 ; i<n; i++){
            pq.add(new Pair(diff[i], arr[i]));
            if(pq.size()>k) pq.poll();
        }
        List<Integer> ans = new ArrayList<>((Collection) Collections.reverseOrder());
        for(int i =0 ; i<k; i++){
         System.out.println(pq.poll().value);
        }

    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] arr = {1,2,3,4,5};
        closest(arr, 4, 3);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
