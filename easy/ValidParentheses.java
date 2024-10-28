import java.util.*;


public class ValidParentheses {

    // https://leetcode.com/problems/valid-parentheses/

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || map.get(c) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
