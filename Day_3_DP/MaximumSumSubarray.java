package Day_3_DP;

import java.util.*;

public class MaximumSumSubarray {

  public static int maxSubarraySum(int[] arr, int n) {
    int maxi = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += arr[j];
        maxi = Math.max(maxi, sum);
      }
    }

    return maxi;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String[] in = sc.nextLine().split(" ");

    int n = in.length;
    // -2 1 -3 4 -1 2 1 -5 4
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(in[i]);
    }

    int maxSum = maxSubarraySum(arr, n);
    System.out.println(maxSum);
  }
}
