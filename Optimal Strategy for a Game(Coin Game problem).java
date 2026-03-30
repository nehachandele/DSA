import java.util.Arrays;

public class GFG {

    static int maxAmount(int i, int j, int[] arr, int[][] dp) {
        // Base case: If i > j, no more elements
        // are left to pick
        if (i > j)
            return 0;

        // If the result is already computed, return
        // from the dp table
        if (dp[i][j] != -1)
            return dp[i][j];

        // Option 1: Take the first element arr[i]
        int takeFirst = arr[i] + Math.min(maxAmount(i + 2, j, arr, dp),
                                          maxAmount(i + 1, j - 1, arr, dp));

        // Option 2: Take the last element arr[j]
        int takeLast = arr[j] + Math.min(maxAmount(i + 1, j - 1, arr, dp),
                                         maxAmount(i, j - 2, arr, dp));

        // Store the maximum of the two choices
        return dp[i][j] = Math.max(takeFirst, takeLast);
    }

    static int maximumAmount(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        int res = maxAmount(0, n - 1, arr, dp);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 10};
        int res = maximumAmount(arr);
        System.out.println(res);
    }
}
