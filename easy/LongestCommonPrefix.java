public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        // https://leetcode.com/problems/longest-common-prefix

        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }
}
