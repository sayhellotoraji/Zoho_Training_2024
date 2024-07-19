package Day_3_DP;

import java.util.Scanner;

public class PallindromicSubstring {

    // Function to preprocess the input string using regex
    static String preprocessString(String str) {
        // Remove non-alphanumeric characters and convert to lowercase
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Function to print the longest palindromic substring
    static void printLongestPalindromicSubstring(String str) {
        int n = str.length();

        // Create a table to store if substring from i to j is palindrome
        boolean[][] dp = new boolean[n][n];

        int maxLength = 1;
        int start = 0;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }

        // Check for substrings of length greater than 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLength) {
                        maxLength = len;
                        start = i;
                    }
                }
            }
        }

        // Print the longest palindromic substring found
        System.out.print("Longest palindromic substring is: ");
        System.out.println(str.substring(start, start + maxLength));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // Preprocess the input string using regex
        String processedInput = preprocessString(input);

        // Find and print the longest palindromic substring
        printLongestPalindromicSubstring(processedInput);

        sc.close();
    }
}
