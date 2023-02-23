package DP.Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
// first 2d dp questions solved without any help

public class Triangle {
    // recursion
    // we usually start from the end of given data, but here an end can have multiple end points,
    // hence increasing number of recursive calls, so we will start from the beginning of the arraylist as we
    // have a fixed point.
    public static int tri(int rows, int ind, ArrayList<ArrayList<Integer>> triangle, int n){
        // as we hit the last row, we return the element at that index.
        if(rows == n-1)
            return triangle.get(rows).get(ind);

        // we calculate the diagonal values and down values, and return the minimum among them.
        int diagonal = triangle.get(rows).get(ind) + tri(rows + 1, ind + 1, triangle, n);

        int down = triangle.get(rows).get(ind) + tri(rows+1,  ind, triangle, n);

        return Math.min(diagonal, down);
    }

    public static int triDP(int rows, int ind, ArrayList<ArrayList<Integer>> triangle, int n, int[][]dp){
        // as we hit the last row, we return the element at that index.
        if(rows == n-1)
            return triangle.get(rows).get(ind);

        if(dp[rows][ind] != -1) return dp[rows][ind];
        // we calculate the diagonal values and down values, and return the minimum among them.
        int diagonal = triangle.get(rows).get(ind) + triDP(rows + 1, ind + 1, triangle, n, dp);

        int down = triangle.get(rows).get(ind) + triDP(rows+1,  ind, triangle, n, dp);


        return dp[rows][ind] = Math.min(diagonal, down);
    }

    // tabulation
    public static int tab(ArrayList<ArrayList<Integer>> triangle, int n, int[][]dp){
        dp[0][0] = triangle.get(0).get(0);
        int rows = triangle.size();
        for (int i = 0; i<rows; i++){
            for (int j = 0; j<i; j++){
                if(i==0 && j ==0){
                    dp[0][0] = triangle.get(0).get(0);
                    continue;
                }
                int diagonal  = triangle.get(0).get(0) + dp[i-1][j-1];
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < 8; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int min = 1;
                int max = 100;
                int randomNum = rand.nextInt((max - min) + 1) + min;
                row.add(randomNum);
            }
            triangle.add(row);
        }

        for (ArrayList<Integer> row : triangle) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        int n = 8;
        int[][] dp = new int[n][n];
        for(int[] SubArray: dp) Arrays.fill(SubArray, -1);

        long startTime = System.nanoTime();

        System.out.println(tri(0, 0, triangle, 8));


        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");

        startTime = System.nanoTime();

        System.out.println(triDP(0,0, triangle, 8, dp));
        endTime = System.nanoTime();
       duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
