package solutions;

public class SingleNumberII {

	public static int singleNumber(int[] nums) {
		int result = 0;
		int bits[] = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int n : nums) {
				bits[i] += n >> i & 1;
				bits[i] %= 3;
			}
		}

		for (int i = 0; i < 32; i++) {
			result |= (bits[i] << i);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(SingleNumberII.singleNumber(
			new int[] { 0, 1, 0, 1, 0, 1, 99 }));
	}

}
