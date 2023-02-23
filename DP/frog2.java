package DP;

public class frog2 {
    public static int frog(int n, int[] arr, int[] dp, int k) {

        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                int step = frog(n - i, arr, dp, k) + Math.abs(arr[n] - arr[n - i]);
                min = Math.min(min, step);
            }
        }
        return dp[n] = min;
    }

    public static int frogJump(int n, int[] heights, int k) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        return frog(n - 1, heights, dp, k);
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {40, 10, 20, 70, 80, 10, 20, 70, 80, 60};
        int k = 4;
        System.out.println(frogJump(n, arr, k));

    }
}
