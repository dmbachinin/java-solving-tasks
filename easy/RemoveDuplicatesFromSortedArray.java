public class RemoveDuplicatesFromSortedArray {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

    public int removeDuplicates(int[] nums) {
        int k = 1;
        int lastNumber = nums[0];
        int insert_pos = -1;
        for (int i = 1; i < nums.length; i++) {
            if (lastNumber == nums[i]) {
                nums[i] = 0;
                if (insert_pos == -1) {
                    insert_pos = i;
                }
            } else {
                if (insert_pos != -1) {
                    nums[insert_pos] = nums[i];
                    insert_pos++;
                }
                lastNumber = nums[i];
                k++;
            }
        }
        return k;
    }
}
