package Day_4_DS;

import java.util.Arrays;
import java.util.Scanner;

// Hashing - By using Arrays
class Solution {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for(int i=0;i<s.length();i++){
            hash1[s.charAt(i)-97]++;
            hash2[t.charAt(i)-97]++;
        }
        if(Arrays.equals(hash1, hash2)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        String t = sc.nextLine().toLowerCase();

        System.out.println(isAnagram(s, t));


    }
}