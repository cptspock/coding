package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A valid IP address consists of exactly four integers separated by single
 * dots. Each integer is between 0 and 255 (inclusive) and cannot have leading
 * zeros.
 * 
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but
 * "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP
 * addresses that can be formed by inserting dots into s. You are not allowed to
 * reorder or remove any digits in s. You may return the valid IP addresses in
 * any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "25525511135" Output: ["255.255.11.135","255.255.111.35"]
 * 
 * Example 2:
 * 
 * Input: s = "0000" Output: ["0.0.0.0"]
 * 
 * Example 3:
 * 
 * Input: s = "101023" Output:
 * ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * 
 * https://leetcode.com/problems/restore-ip-addresses/description/
 */
public class RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		int len = s.length();
		if (len > 12)
			return result;

		StringBuffer ip = new StringBuffer();
		for (int aLen = 1; aLen <= 3; aLen++) {
			for (int bLen = 1; bLen <= 3; bLen++) {
				for (int cLen = 1; cLen <= 3; cLen++) {
					int dLen = len - aLen - bLen - cLen;
					if (dLen > 0 && dLen <= 3) {
						int A = Integer.parseInt(s.substring(0, aLen));
						int B = Integer
							.parseInt(s.substring(aLen, aLen + bLen));
						int C = Integer.parseInt(
							s.substring(aLen + bLen, aLen + bLen + cLen));
						int D = Integer
							.parseInt(s.substring(aLen + bLen + cLen));

						if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
							ip.append(A).append(".").append(B).append(".")
								.append(C).append(".").append(D);

							// check for leading 0's since when you convert from
							// string to int leading 0s will be lost
							if (ip.length() == len + 3) {
								result.add(ip.toString());
							}
							ip = new StringBuffer();
						}
					}
				}
			}
		}
		return result;
	}

	// Backtracking solution
	public List<String> restoreIpAddresses2(String s) {
		List<String> result = new ArrayList<>();
		int len = s.length();
		if (len < 4 || len > 12)
			return result;
		backtrack(s, 0, new LinkedList<String>(), result);
		return result;
	}

	private void backtrack(String s, int idx, LinkedList<String> curr,
		List<String> result) {

		if (curr.size() == 4) {
			if (idx == s.length()) {
				result.add(String.join(".", curr));
			}
			return;
		}

		// bulk of the algo
		StringBuffer num = new StringBuffer();
		for (int i = idx; i < Math.min(idx + 3, s.length()); i++) {
			num.append(s.charAt(i));
			if (num.charAt(0) == '0' && num.length() > 1) {
				break;
			}
			int number = Integer.parseInt(num.toString());
			if (number >= 0 && number <= 255) {
				curr.add(num.toString());
				backtrack(s, i + 1, curr, result);
				curr.removeLast();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(
			new RestoreIPAddresses().restoreIpAddresses("25525511135"));
		System.out.println("-------------------");
		System.out.println(new RestoreIPAddresses().restoreIpAddresses("0000"));
		System.out.println("-------------------");
		System.out
			.println(new RestoreIPAddresses().restoreIpAddresses("101023"));
		System.out.println("-------------------");
		System.out
			.println(new RestoreIPAddresses().restoreIpAddresses("0011255245"));
		System.out.println(
			new RestoreIPAddresses().restoreIpAddresses2("25525511135"));
		System.out.println("-------------------");
		System.out
			.println(new RestoreIPAddresses().restoreIpAddresses2("0000"));
		System.out.println("-------------------");
		System.out
			.println(new RestoreIPAddresses().restoreIpAddresses2("101023"));
		System.out.println("-------------------");
		System.out.println(
			new RestoreIPAddresses().restoreIpAddresses2("0011255245"));

	}

}
