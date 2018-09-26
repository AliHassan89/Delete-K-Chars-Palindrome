/*

Given a string which we can delete at most k, return whether you can make a palindrome

 */
package main.java;

public class PalindromeString {

    public static void main(String[] args) {
        System.out.println(isPalindromicStringCreatable("naitqin", 2));
    }

    private static boolean isPalindromicStringCreatable(String str, int k) {
        String reversed = reverseString(str);
        int deletions = deleteElementsToCreatePalindrome(str, reversed, str.length());
        return deletions <= k*2;
    }

    private static int deleteElementsToCreatePalindrome(String str, String reversed, int len) {
        int[][] dp = new int[len + 1][len + 1];

        for (int i = 0; i <= len; i++)
        {
            for (int j = 0; j <= len; j++)
            {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (str.charAt(i - 1) == reversed.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[len][len];
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i=str.length() - 1; i>=0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}
