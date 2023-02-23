package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    static  List<List<Integer>> ans = new ArrayList<>();

    public static void ksum(int i ,List<Integer> subs, int[] nums,List<List<Integer>> ans){
        int n = nums.length;
        if(i>=n){

            if(!ans.contains(subs)) ans.add(new ArrayList<>(subs));
            return;
        }
        // taking the element
        subs.add(nums[i]);
        ksum(i+1, subs, nums, ans);

        // not taking the element
        subs.remove(subs.size()-1);
        ksum(i+1, subs, nums, ans);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subs = new ArrayList<>();
        ksum(0, subs, nums,ans);
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {4,4,4,1,4};
       System.out.println(subsetsWithDup(nums));
    }
}
