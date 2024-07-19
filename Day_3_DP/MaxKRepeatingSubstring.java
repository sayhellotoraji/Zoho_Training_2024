package Day_3_DP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class MaxKRepeatingSubstring {
    
    public static int maxKRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        
        int[] dp = new int[n];
        
        Pattern pattern = Pattern.compile("(" + Pattern.quote(word) + ")+");
        
        for (int i = 0; i < n; i++) {

            Matcher matcher = pattern.matcher(sequence.substring(0, i + 1));
            
            int maxK = 0;
            
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                int len = end - start;
                
                int k = len / m;
                
                maxK = Math.max(maxK, k);
            }
            
            dp[i] = maxK;
        }
        
        int result = 0;
        for (int value : dp) {
            result = Math.max(result, value);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sequence1 = sc.nextLine();
        String word1 = sc.nextLine();
        System.out.println(maxKRepeating(sequence1, word1)); 
      
    }
}

