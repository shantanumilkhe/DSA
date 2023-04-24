package leetcode;

public class leet42 {
    public static int leet(int[] heights){

        int n = heights.length;
        int l = 0;
        int r = n-1;
        int water = 0;
     for(int i =0; i<n; i++){
           if(Math.min(l, r)==l){
               int cur = l-heights[i];
               if(cur>=0) water+=cur;
               l = Math.min(heights[i],l);
           }else{
               int cur = r-heights[i];
               if(cur>=0) water+=cur;
               r = Math.min(heights[i],r);
           }
       }
        return water;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Write your code here

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
