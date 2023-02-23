package DP.subsets;

public class rodCutting {
    public static int rod(int n, int len, int[] price){
        if(n==0){
            return len*price[0];
        }

        int not_take = rod(n-1, len, price);
        int take = Integer.MIN_VALUE;
        if(n+1<=len)  take = price[n] + rod(n,len-(n+1), price);

        return Math.max(not_take, take);
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();


        int price[] = {2,5,7,8,10};

        int n = price.length;

        System.out.println("The Maximum price generated is "+rod(n-1, n, price));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
