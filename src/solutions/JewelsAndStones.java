package solutions;

import java.util.HashSet;

/**
 * You're given strings jewels representing the types of stones that are jewels,
 * and stones representing the stones you have. Each character in stones is a
 * type of stone you have. You want to know how many of the stones you have are
 * also jewels.
 * 
 * Letters are case sensitive, so "a" is considered a different type of stone
 * from "A".
 * 
 * https://leetcode.com/problems/jewels-and-stones/
 * 
 *
 */

public class JewelsAndStones {
	public static int numJewelsInStones(String jewels,
		String stones) {
		HashSet<Character> jewelsSet = new HashSet<>();
		int jewelCount = 0;
		for (char j : jewels.toCharArray()) {
			jewelsSet.add(j);
		}
		for (char s : stones.toCharArray()) {
			if (jewelsSet.contains(s)) {
				jewelCount++;
			}
		}
		return jewelCount;

	}

	public static void main(String[] args) {
		System.out.println(JewelsAndStones
			.numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(
			JewelsAndStones.numJewelsInStones("z", "ZZZ"));
	}

}
