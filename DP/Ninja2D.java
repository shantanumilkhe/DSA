package DP;

import java.util.Arrays;

public class Ninja2D {
    //recursion
    public static int ninja(int ind, int last, int[][] task){
        // check if we are at the last index or not
        // if yes, then check for the last index the highest number of points
        //that can be achieved, given the last task.
        if(ind ==0){
            int max =0;
            for (int i=0; i<=2; i++){
                if(i!= last){
                    max = Math.max(max, task[0][i]);
                }
            }
            // then return the max value that is calculated.
            return max;
        }

        // if the index is not equal to zero then,
        // again set max to 0, then using the For loop calculate the highest number of points
        // that can be achieved, given the last task was i.

        int max = 0;
        for(int i = 0; i<= 2; i++){
            if (i!=last){
            int points = task[ind][i] + ninja(ind-1, i, task);
            max = Math.max(max, points);
            }
        }

        //then returns the maximum calculated.
        return max;
    }
    //memoization
    public static int ninjaDP(int ind, int last, int[][] task, int[][] dp){
        if(ind ==0){
            int max =0;
            for (int i=0; i<=2; i++){
                if(i!= last){
                    max = Math.max(max, task[0][i]);
                }
            }
            return dp[ind][last]=max;
        }
        if(dp[ind][last]!=-1 ) return dp[ind][last];
        int max = 0;
        for(int i = 0; i<= 2; i++){
            if (i!=last){                   // the next task is added by doing a recursive call;
                int points = task[ind][i] + ninjaDP(ind-1, i, task, dp);
                max = Math.max(max, points);
            }
        }

        return dp[ind][last] = max;
    }
    //tabulation
    public static int ninjaTab(int n, int[][] task, int[][] dp){
        // Initialize the DP for the 0th day.
        dp[0][0] = Math.max(task[0][1], task[0][2]);
        dp[0][1] = Math.max(task[0][0], task[0][2]);
        dp[0][2] = Math.max(task[0][0], task[0][1]);
        dp[0][3] = Math.max(task[0][0], Math.max(task[0][1], task[0][2]));

        //after that, we will mimic the recursion call.
        //create two for loops to iterate through the task 2d array,
        // then do the same as recursion for each task.
        // but instead of recursive call, as this is tabulation, it is a bottom up approach.
        // so we have the data of the previous day.
        // and add that data.
        for (int day =1; day<n; day++){
            for (int last= 0; last<4; last++){
                dp[day][last] = 0;
                int maxi = 0;
                for (int i = 0; i<=2; i++){
                    if (i!=last){
                        int points = task[day][i] + dp[day-1][i];
                        maxi = Math.max(points, maxi);
                    }
                }
                dp[day][last] = maxi;
            }
        }
        return dp[n-1][3];
    }

    //space optimization
    public static int ninjaSpace(int n, int[][] task){
        int[] prev = new int[4];
        // Initialize the DP for the 0th day.
        prev[0] = Math.max(task[0][1], task[0][2]);
        prev[1] = Math.max(task[0][0], task[0][2]);
        prev[2] = Math.max(task[0][0], task[0][1]);
        prev[3] = Math.max(task[0][0], Math.max(task[0][1], task[0][2]));

        //after that, we will mimic the recursion call.
        //create two for loops to iterate through the task 2d array,
        // then do the same as recursion for each task.
        // but instead of recursive call, as this is tabulation, it is a bottom up approach.
        // so we have the data of the previous day.
        // and add that data.
        for (int day =1; day<n; day++){

            int[] temp = new int[4];
            Arrays.fill(temp, 0);

            for (int last= 0; last<4; last++){
                temp[last] = 0;

                for (int i = 0; i<=2; i++){
                    if (i!=last){
                        temp[last] = Math.max(temp[last], task[day][i] + prev[i]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }
    public static void main(String[] args){

        long startTime = System.nanoTime();
        int[][] tasks = {{10 ,40, 70}, {20 ,50 ,80}, {30 ,60 ,90}};
        int n = 3;

        // to convert the recursion to DP, initialize a new 2d array, but with number of columns being
        // 4, an extra fourth column is added to the case that if there given array contains only one day.
        // so there is no last pointer to avoid and hence calculating the max of all the three tasks and
        // storing them in the 4th column.
        int[][] dp = new int[n][4];
        for(int[] subArray: dp){
            Arrays.fill(subArray, -1);
        }


        //System.out.println(ninja(n-1, 3, tasks));


        //System.out.println(ninjaDP(n-1, 3, tasks, dp));


        //System.out.println(ninjaTab(n, tasks, dp));

        System.out.println(ninjaSpace(n, tasks));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
