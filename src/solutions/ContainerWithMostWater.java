package solutions;

/**
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 Explanation: The above
 * vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49.
 * 
 * https://leetcode.com/problems/container-with-most-water/
 * 
 *
 */
public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int water = 0;
		int area = 0;

		while (left < right) {
			area = Math.abs(left - right)
				* Math.min(height[left], height[right]);
			water = Math.max(area, water);
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return water;

	}

	public static void main(String[] args) {
		int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(new ContainerWithMostWater().maxArea(height));
		height = new int[] { 1, 1 };
		System.out.println(new ContainerWithMostWater().maxArea(height));
	}

}
