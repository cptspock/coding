package interview;

public class MinNumberOfCoins {
	public static int getMinNumberOfCoins(int n, int[] denoms) {
		int[] numOfCoins = new int[n + 1];
		for (int i = 0; i < numOfCoins.length; i++) {
			numOfCoins[i] = n + 1; // highest number of coins which is 1*n + 1
		}
		numOfCoins[0] = 0;
		for (int denom: denoms) {
			for (int amount = 1; amount < numOfCoins.length; amount++) {
				if (denom <= amount) {
					numOfCoins[amount] = Math.min(numOfCoins[amount], numOfCoins[amount - denom] + 1);
				}
			}
		}
		return numOfCoins[n] <= n ? numOfCoins[n] : -1;
	}
	
	public static void main(String[] args) {
		System.out.print(new MinNumberOfCoins().getMinNumberOfCoins(5, new int[] {2}));	
	}

}
