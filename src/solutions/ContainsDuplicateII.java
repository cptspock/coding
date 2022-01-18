package solutions;

import java.util.HashMap;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums,
		int k) {
		HashMap<Integer, Integer> numberIndexMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (numberIndexMap.containsKey(nums[i]) && ((i
				- numberIndexMap.get(nums[i])) <= k)) {
				return true;
			} else {
				numberIndexMap.put(nums[i], i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new ContainsDuplicateII()
			.containsNearbyDuplicate(
				new int[] { 1, 2, 3, 1, 2, 3 }, 2));
		System.out.println(new ContainsDuplicateII()
			.containsNearbyDuplicate(
				new int[] { 1, 0, 1, 1 }, 1));
	}

}
