package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class leet128 {

    public static int longest(int[] nums){

        HashSet<Integer> set = new HashSet<>();

        int max = 0;
        for(int i =0; i<nums.length; i++){
           set.add(nums[i]);
        }

        for(int i =0; i<nums.length; i++){
            if(!set.contains(nums[i]-1)){
                int len =0;
                while(set.contains(nums[i]+len)){
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

       int[] ar = {100,4,200,1,3,2};
       System.out.println(longest(ar));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
