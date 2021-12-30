package interview;

import java.util.ArrayList;
import java.util.List;

public class ConverPrimitiveIntArrayToIntegerArray {

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3};
		List<Integer> list = new ArrayList<>();
		for (int i : nums) 
			list.add(i);
		for (Integer i : list) 
			System.out.println(i);
	}

}
