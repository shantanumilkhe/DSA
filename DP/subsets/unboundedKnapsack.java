package DP.subsets;

public class unboundedKnapsack {

    public static int unbound(int n, int w, int[][]items){
        if(n==0){
           return  ((int)(w / items[0][0])) * items[1][0];
        }

        int not_take = unbound(n-1, w, items);
        int take = Integer.MIN_VALUE;
        if(items[0][n]<=w){
            take = items[1][n]+unbound(n, w-items[0][n], items );
        }

        return Math.max(take, not_take);
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();


        int[][] items = {{2,4,6} ,{5,11,13}};
        int w = 10;
        System.out.println(unbound(2, w, items));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
