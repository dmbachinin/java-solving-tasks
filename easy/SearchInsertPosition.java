public class SearchInsertPosition {
    // https://leetcode.com/problems/search-insert-position/
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int rigth = nums.length;

        while(left < rigth) {
            int center = left + (rigth - left) / 2;
            if (target == nums[center]) {
                return center;
            } else if (target < nums[center]) {
                rigth = center;
            } else {
                left = center + 1;
            }
        }
        return left;
    }
}
