/**
 * 
 * https://leetcode.com/problems/first-bad-version/
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, 
 * the latest version of your product fails the quality check. Since each version is developed based 
 * on the previous version, all the versions after a bad version are also bad.

   Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
   which causes all the following ones to be bad.

   You are given an API bool isBadVersion(version) which returns whether version is bad. 
   Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
package solutions;

public class FirstBadVersion {

	public boolean isBadVersion(int version) {
		return false;
	}

	public int firstBadVersion(int n) {
		int low = 1;
		int high = n;
		int mid;
		int result = n;

		while (low <= high) {
			mid = low + (high - low) / 2; // if n = 1, then mid needs to be 1. Also to prevent overflow.
			if (isBadVersion(mid)) {
				result = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
