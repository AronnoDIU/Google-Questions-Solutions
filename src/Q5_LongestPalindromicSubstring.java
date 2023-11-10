/* Given a string s, find the longest palindromic substring in s. You may assume
that the maximum length of s is 1000.
Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:
Input: "cbbd"
Output: "bb" */
public class Q5_LongestPalindromicSubstring {
    // Time Complexity: O(n^2)
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int start = 0, end = 0;

        // Expand around a center to find the longest palindrome
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Check for odd length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // Check for even length palindromes
            int len = Math.max(len1, len2); // Choose the longer length

            // Update the start and end of the longest palindrome
            if (len > maxLength) {
                maxLength = len; // Update the maximum length
                start = i - (len - 1) / 2; // Update the start index
                end = i + len / 2; // Update the end index
            }
        }
        return s.substring(start, end + 1); // Return the longest palindrome
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        String result = new Q5_LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(result);
    }
}

/*Expected Output:

bab

* */