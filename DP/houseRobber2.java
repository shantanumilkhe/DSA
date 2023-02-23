package DP;
import java.util.Arrays;
public class houseRobber2 {
    //Space Optimized Tabulation
    public static int solve(int n, int[] arr){

        int prev = arr[0];
        int prev2 =0;


        for(int i=1; i<n; i++){
            int pick = arr[i];
            if(i>1)
                pick += prev2;
            int nonPick = prev;

            int cur_i = Math.max(pick, nonPick);

            prev2 = prev;
            prev= cur_i;

        }
        return prev;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        int n = nums.length;
        int[] arr1 = new int[n-1];
        for(int i = 0; i<arr1.length; i++){
            arr1[i]=nums[i+1];
        }
        int first = solve(n-1, arr1);
        int[] arr2 = new int[n-1];
        for(int i = 0; i<arr2.length; i++){
            arr2[i]=nums[i];
        }
        int last = solve(n-1, arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Math.max(first, last));
    }
}
