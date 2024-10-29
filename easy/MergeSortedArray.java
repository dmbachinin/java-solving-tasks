public class MergeSortedArray {

    // https://leetcode.com/problems/merge-sorted-array/

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i2 = 0; i2 < nums2.length; i2++) {
            int insertPos = 0;
            while (insertPos < m + i2
                    && nums2[i2] >= nums1[insertPos]) {
                insertPos++;
            }
            for (int i1 = m + i2; i1 > insertPos; i1--) {
                nums1[i1] = nums1[i1 - 1];
            }
            nums1[insertPos] = nums2[i2];
        }
    }
}
