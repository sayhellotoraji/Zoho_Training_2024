package Day_4_DS;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

public class TwoSum {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] in = sc.nextLine().split(" ");

    int n = in.length;

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(in[i]);
    }

    int target = sc.nextInt();

    int[] ans = new int[2];

    ans[0] = ans[1] = -1;
    
    HashMap<Integer, Integer> mpp = new HashMap<>();
    
    for (int i = 0; i < n; i++) {
        int num = arr[i];
        int moreNeeded = target - num;
      
        if (mpp.containsKey(moreNeeded)) {
            ans[0] = mpp.get(moreNeeded);
            ans[1] = i;
        }

      mpp.put(arr[i], i);
    }

    System.out.println(Arrays.toString(ans));
  }
}
