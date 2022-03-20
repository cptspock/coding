package solutions;

public class HammingDistance {
	public static int hammingDistance(int x, int y) {
		int xor = x ^ y;
		int hammingDistance = 0;
		while (xor > 0) {
			if (xor % 2 == 1) {
				hammingDistance++;
			}
			xor = xor >> 1;
		}
		return hammingDistance;
	}

	public static void main(String[] args) {
		System.out
			.println(HammingDistance.hammingDistance(1, 3));
	}

}
