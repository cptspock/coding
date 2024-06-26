package solutions;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesSorted {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				continue;
			} else {
				nums[count] = nums[i];
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		System.out.println(new RemoveDuplicatesSorted()
			.removeDuplicates(new int[] { 1, 1, 2 }));
		System.out.println(new RemoveDuplicatesSorted()
			.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}
}
