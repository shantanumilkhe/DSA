package DP.Stocks;


public class stocks1 {

    //Approach:

//    The algorithm approach can be stated as:
//
//    Initialize a variable ‘maxProfit’ to 0 and declare another variable ‘mini’ which we will
//    use to keep track of the buying price (minimum price from day 0 to day i) for selling the stock.

//    Traverse the array from index 1 to n-1. We started at index 1 because buying and selling
//    the stock on the 0th day will give us a profit of 0, which we have initialized our
//    maxProfit as already.

//    In each iteration, try to find the curProfit. The selling price will be Arr[i] and ‘mini’
//    will give us the buying price. We calculate the curProfit. If it is more than the existing
//    profit value (maxProfit), we update the maxProfit value.

//    Before going to the next iteration, we check if the current price (Arr[i]) is less than the
//    mini value, and we assign it as the new mini value. In this way, we keep track of the buying
//    price in a single iteration itself.
    public static int sellbuy(int[] prices){

      int mini = prices[0];
      int profit = 0;
      for(int i=1; i<prices.length; i++){
          int cost = prices[i] - mini;
          profit = Math.max(cost, profit);
          mini = Math.min(mini, prices[i]);
      }
      return profit;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

       int[] prices = {7,1,5,3,6,4};
       System.out.println(sellbuy(prices));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
