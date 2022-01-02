package solutions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static List<List<Integer>> getPermutations(int[] nums) {
		List<Integer> array = new ArrayList<>();
		for (int i : nums)
			array.add(i);
		List<List<Integer>> permutations = new ArrayList<>();
		permutationsHelper(array, new ArrayList<Integer>(), permutations);
		return permutations;
	}

	public static void permutationsHelper(List<Integer> array, List<Integer> currentPermutation,
			List<List<Integer>> permutations) {
		if (array.size() == 0 && currentPermutation.size() > 0) {
			permutations.add(currentPermutation);
		} else {
			for (int i = 0; i < array.size(); i++) {
				List<Integer> newArray = new ArrayList<>(array);
				newArray.remove(i);
				List<Integer> newPermutation = new ArrayList<>(currentPermutation);
				newPermutation.add(array.get(i));
				permutationsHelper(newArray, newPermutation, permutations);
			}
		}

	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> perms = new Permutations().getPermutations(nums);
		for (List<Integer> list : perms) {
			for (Integer num : list) {
				System.out.print(num);
			}
			System.out.println("");
		}
	}

}
