/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 * https://www.youtube.com/watch?v=V2VrBK5FjoY
 * https://www.youtube.com/watch?v=0y7pU6PPrc4&t=339s
 */
package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> repeatedSequences = new ArrayList<>();
		Map<String, Integer> freq = new HashMap<>();
		for (int i = 0; i <= s.length() - 10; i++) { // subtract 10 to avoid going out of bounds in the string
			String dna = s.substring(i, i + 10); // char at the 2nd value does not get included in substring
			freq.put(dna, freq.getOrDefault(dna, 0) + 1);
			if (freq.get(dna) == 2) { // as soon as you find duplicates add it
				repeatedSequences.add(dna);
			}
		}
		return repeatedSequences;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTTAAAAACCCCC"));
	}

}
