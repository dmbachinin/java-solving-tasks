import java.util.SortedSet;
import java.util.TreeSet;

public class SingleNumber {
    // https://leetcode.com/problems/single-number/
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }
}
