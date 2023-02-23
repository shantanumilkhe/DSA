package DP;


public class frog {
    public static int frogRec(int n, int[] arr) {

        int step1 = Integer.MAX_VALUE;
        int step2 = Integer.MAX_VALUE;
        if (n == 0) return 0;
        step1 = frogRec(n - 1, arr) + Math.abs(arr[n] - arr[n - 1]);
        if (n > 1) {
            step2 = frogRec(n - 2, arr) + Math.abs(arr[n] - arr[n - 2]);
        }
        return Math.min(step1, step2);
    }


    public static int frog(int n, int arr[], int[] dp) {

        int step1 = Integer.MAX_VALUE;
        int step2 = Integer.MAX_VALUE;
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        step1 = frog(n - 1, arr, dp) + Math.abs(arr[n] - arr[n - 1]);
        if (n > 1) {
            step2 = frog(n - 2, arr, dp) + Math.abs(arr[n] - arr[n - 2]);
        }
        return dp[n] = Math.min(step1, step2);
    }

    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        return frog(n - 1, heights, dp);
    }

    public static int frogTab(int n, int[] arr) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        n = n - 1;
        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);

            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 4;
        int[] arr = {10, 20, 30, 10};
        System.out.println(frogJump(n, arr));
        System.out.println(frogTab(n, arr));
    }

}


