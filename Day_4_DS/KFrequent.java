package Day_4_DS;

import java.util.*;

public class KFrequent  {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Convert frequency map to a list of map entries and sort by frequency
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        
        // Step 3: Extract the top k frequent elements
        List<Integer> topKElements = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topKElements.add(entryList.get(i).getKey());
        }
        
        return topKElements;
    }
    
    public static void main(String[] args) {

        // Example 1
        // int[] nums1 = {1, 1, 1, 2, 2, 3};
        // int k = 2;

        Scanner sc = new Scanner(System.in);

        String[] in = sc.nextLine().split(" ");
        
        int n = in.length;
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(in[i]);
        }

        int k  = sc.nextInt();

        System.out.println(topKFrequent(arr, k));
        
   }
}
