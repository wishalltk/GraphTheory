package com.dynamicProgramming;

public class G_LongestPalindromicSubString {
    public static void main(String[] args) {
        String input = "forgeeksskeegfor";
        int len = longestPalindromeLength(input);
        System.out.println(len);

    }

    private static int longestPalindromeLength(String input) {
        int n = input.length();
        int maxLength = 1;
        String longest = "";
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<=n;j++) {
                String sub = input.substring(i, j);
                if(isPalindrome(sub)) {
                    if(sub.length() > maxLength) {
                        maxLength = sub.length();
                        longest = sub;
                    }
                }
            }
        }
        System.out.println(longest);
        return maxLength;
    }

    private static boolean isPalindrome(String sub) {
        int n =  sub.length();
        int left = 0;
        int right = n-1;
        while (left < right) {
            if(sub.charAt(left) != sub.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }
}
