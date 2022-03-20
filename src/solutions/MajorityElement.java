package solutions;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static int majorityElement(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.containsKey(i)
				&& map.get(i) + 1 > nums.length / 2) {
				return i;
			} else {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(MajorityElement
			.majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(MajorityElement.majorityElement(
			new int[] { 2, 2, 1, 1, 1, 2, 2 }));
		System.out.println(MajorityElement
			.majorityElement(new int[] { 1, 2, 3 }));

	}

}
