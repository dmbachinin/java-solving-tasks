public class LongestPalindrome {
    // https://leetcode.com/problems/longest-palindromic-substring
    public String longestPalindrome(String s) {
        int palindrome_left_pos = 0;
        int palindrome_rigth_pos = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int left_pos = i;
            int rigth_pos = i + 1;

            char left_char = s.charAt(left_pos);
            char rigth_char;
            boolean isCheck = false;
            while(left_char == s.charAt(rigth_pos)) {
                isCheck = true;
                if (rigth_pos + 1 >= s.length()) {
                    break;
                }
                rigth_pos++;
            }
            if (!isCheck) {
                rigth_pos = left_pos;
            } else if (left_char != s.charAt(rigth_pos)) {
                rigth_pos--;
            }
            while (left_pos >= 0 && rigth_pos < s.length()) {
                left_char = s.charAt(left_pos);
                rigth_char = s.charAt(rigth_pos);
                if (left_char == rigth_char) {
                    if (palindrome_rigth_pos - palindrome_left_pos <= rigth_pos - left_pos) {
                        palindrome_left_pos = left_pos;
                        palindrome_rigth_pos = rigth_pos;
                    }
                    left_pos--;
                    rigth_pos++;
                } else {
                    break;
                }
            }
        }
        return s.substring(palindrome_left_pos, palindrome_rigth_pos + 1);
    }
}
