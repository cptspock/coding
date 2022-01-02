package solutions;

public class NumberOfWaysChange {
	public static int numberOfWays(int n, int[] denoms) {
		int[] ways = new int[n + 1];
		ways[0] = 1;
		for (int denom : denoms) {
			for (int amount = 1; amount < n + 1; amount++) {
				if (denom <= amount)
					ways[amount] += ways[amount - denom];
			}
		}
		return ways[n];
	}
	public static void main(String[] args) {
		System.out.print(new NumberOfWaysChange().numberOfWays(5, new int[] {1,2,3}));
	}

}
