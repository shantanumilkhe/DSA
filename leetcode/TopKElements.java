package leetcode;

import java.util.*;

class k{
    int freq, value;
    public k(int freq,int value){
        this.freq = freq;
        this.value = value;
    }
}
public class TopKElements {
    public static void kl(int[] arr, int k){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            if (map.get(j) == null) {
                map.put(j, 1);
            } else {
                int c =1+ map.get(j);
                map.put(j, c);
            }
        }
        PriorityQueue<k> pq = new PriorityQueue<>((x,y)->(x.freq-y.freq));

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){

            pq.add(new k(entry.getValue(), entry.getKey()));
//            if(pq.size()>k) pq.remove();
        }

//       for(int i = 0; i<k; i++){
//           System.out.println(pq.poll().value);
//       }

        int[] ans = new int [n];

        for(int i =0; i<pq.size(); i++){
            k a = pq.poll();
            for(int j = 0; j< a.freq; j++){
                System.out.println(a.value);
            }
        }
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] arr = {1,1,2,1,5,4,4,3,2,2,3,5,4,5,1,2,3,4,3};

        kl(arr, 2);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
