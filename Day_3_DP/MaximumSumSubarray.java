package Day_3_DP;

import java.util.*;

public class MaximumSumSubarray {
    public static void maxSubArraySum(int[] a) {
        int size = a.length;
        int[] dp = new int[size]; 
        dp[0] = a[0]; 
        int ans = dp[0]; 
        for (int i = 1; i < size; i++) {
            dp[i] = Math.max(a[i], a[i] + dp[i - 1]);
            
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String[] in = sc.nextLine().split(" ");

    int n = in.length;
    // -2 1 -3 4 -1 2 1 -5 4
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(in[i]);
    }
        maxSubArraySum(arr); 
    }
}
