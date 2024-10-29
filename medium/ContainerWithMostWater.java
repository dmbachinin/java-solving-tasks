public class ContainerWithMostWater {

    // https://leetcode.com/problems/container-with-most-water/

    public int maxArea(int[] height) {
        int left = 0;
        int rigth = height.length - 1;
        int maxArea = 0;
        while (left != rigth) {
            int minLocalHeight = Math.min(height[left], height[rigth]);
            int localWidth = rigth - left;
            int localArea = localWidth * minLocalHeight;
            maxArea = Math.max(maxArea, localArea);
            if (height[left] > height[rigth]) {
                rigth--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
